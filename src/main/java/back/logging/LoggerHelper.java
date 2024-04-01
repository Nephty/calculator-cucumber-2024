package back.logging;

import back.calculator.Main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

/**
 * Class that holds all required methods in order to ensure a proper logging process.
 * Log files are stored at [user.home]/.logs/calculator-cucumber/. On Unix, [user.home] will be /home/[username].
 * On Windows, [user.home] will be [your_disk]\Users\[username], where [your_disk] is the disk where Windows is
 * installed. Each log file will be named by their date and time of creation.
 */
public class LoggerHelper {
    static String userHome = System.getProperty("user.home");
    static String logFilePath = Paths.get(userHome, ".logs", "calculator-cucumber", generateLogFileName()).toString();

    /**
     * Whether to delete the XML logs or not after transforming them to HTML when the application shutdowns.
     */
    private static final boolean DELETE_XML_LOGS = false;

    /**
     * Perform this when stopping the application :
     * - wait until the logs' lock file disappears ;
     * - transform XML logs into HTML ;
     * - delete XML logs if requested.
     */
    static Thread shutdownHook = new Thread(() -> {
        // (good practice) Wait until the lock file disappears (delay is in ms)
        Path lockFilePath = Paths.get(logFilePath + ".lck");
        float counter = 0, max_waiting_time = 5000, delay = 250;
        while (Files.exists(lockFilePath)) {
            if (counter * delay >= max_waiting_time) break; // Exit if we wait for too long
            counter++;
            try {
                Thread.sleep((long) delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted while waiting for .lck file to disappear", e);
            }
        }

        try {
            transformLogToHTML(logFilePath);
            if (DELETE_XML_LOGS) Files.deleteIfExists(Paths.get(logFilePath));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            // This is intended : if the logging system is set up properly, it will not throw errors.
            // If it ends up throwing an error, there's an issue in the code (or with the permissions).
            // Thus, we should not try to handle the issue but rather notice it and fix the code.
            throw new RuntimeException(e);
        }
    });

    /**
     * Prepares the logger of the application by setting the path to the log file, giving the proper log formatting and
     * adding a shutdown hook that will transform the XML logs into a human-readable HTML file.
     * @return The path to the log file.
     */
    public static String prepareLogger(Logger logger) throws IOException {
        // Create directories if they don't exist
        File logFile = new File(logFilePath);
        File logDir = logFile.getParentFile();
        if (!logDir.exists()) {
            if (!logDir.mkdirs()) throw new RuntimeException("Logs directory does not exist and wasn't able to create it. Do I have enough permissions ?");
        }

        logger.setLevel(Level.ALL);

        // Create FileHandler with the dynamic log file path
        FileHandler fh = new FileHandler(logFilePath);
        logger.addHandler(fh);

        // Configure logger
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                return "[" + record.getLevel() + "] " + record.getMessage() + "\n";
            }
        });
        logger.addHandler(handler);

        Runtime.getRuntime().addShutdownHook(shutdownHook);


        Main.logger.log(Level.INFO, "Logger ready.");

        return logFilePath;
    }

    /**
     * Generates a log file name in the following format : dd-MM-yyyy_HH:mm:ss
     * For example, if the application is run at 31 dec 2024 at 23:59:50 the log file will be named 31-12-2024_23:59:50.
     * @return The log file name
     */
    private static String generateLogFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        return now.format(formatter) + ".log";
    }

    /**
     * Transforms a given log file into an html file. The resulting html file will be in the same directory as the
     * original log file and will have the same name (except that it ends in .html instead of .log).
     */
    public static void transformLogToHTML(String logFilePath) throws IOException, ParserConfigurationException, SAXException {
        // Read log file content
        String logContent = readLogFileContent(logFilePath);

        // Parse modified log content as XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(logContent));
        Document doc = builder.parse(is);

        // Get all log records and create a HTML table
        NodeList recordList = doc.getElementsByTagName("record");
        StringBuilder htmlContent = buildLogsTable(recordList);

        // Save HTML
        Path logFileStringPathAsPathObject = Paths.get(logFilePath);
        Path parentDirectory = logFileStringPathAsPathObject.getParent();
        String htmlFileName = logFileStringPathAsPathObject.getFileName().toString().replace(".log", ".html");
        String htmlFilePath = parentDirectory.resolve(htmlFileName).toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFilePath))) {
            writer.write(htmlContent.toString());
        }
    }

    /**
     * Reads the content of the log file at the given path.
     * Will close the initial [log] tag on its own if called before it was properly closed by the logger itself
     * (for example when we try to read the logs before stopping the program).
     * @return Its content as a string
     */
    private static String readLogFileContent(String logFilePath) throws IOException {
        StringBuilder logContent = new StringBuilder();
        String line, beforeLastLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            while ((line = reader.readLine()) != null) {
                // Skip the DOCTYPE declaration line otherwise it throws an error because it can't find the DTD.
                // We can skip the DOCTYPE and DTD part since we don't need the DTD pre-processing.
                if (!line.contains("DOCTYPE")) {
                    logContent.append(line).append(System.lineSeparator());
                }
                beforeLastLine = line;
            }
        }
        // This is present in case we try to transform the XML file before it is fully closed (before we append the
        // </log> tag). This would be the case if we try to transform it into HTML before we close the program.
        if (!beforeLastLine.equals("</log>")) {
            System.out.println("appended");
            logContent.append("</log>");
        }
        return logContent.toString();
    }

    /**
     * Builds an HTML table containing all logs.
     */
    private static StringBuilder buildLogsTable(NodeList recordList) {
        // Create HTML table
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html><html><head><title>Log File</title></head><body><table border=\"1\"><tr>")
                .append("<th>Date</th><th>Level</th><th>Class</th><th>Method</th><th>Thread</th><th>Message</th></tr>");

        // Iterate over record elements and extract information into the HTML table
        for (int i = 0; i < recordList.getLength(); i++) {
            addRecord((Element) recordList.item(i), htmlContent);
        }

        // Close HTML table and body
        htmlContent.append("</table></body></html>");
        return htmlContent;
    }

    /**
     * Adds a row for the given <code>record</code> to the given <code>htmlContent</code> table (this table is a
     * <code>StringBuilder</code>).
     * @param record The record to add
     * @param htmlContent The table to which to add the record
     */
    private static void addRecord(Element record, StringBuilder htmlContent) {
        String date = record.getElementsByTagName("date").item(0).getTextContent();
        String level = record.getElementsByTagName("level").item(0).getTextContent();
        String clazz = record.getElementsByTagName("class").item(0).getTextContent();
        String method = record.getElementsByTagName("method").item(0).getTextContent();
        String thread = record.getElementsByTagName("thread").item(0).getTextContent();
        String message = record.getElementsByTagName("message").item(0).getTextContent();

        // Append row to HTML table
        htmlContent.append("<tr>")
                .append("<td>").append(date).append("</td>").append("<td style=\"color: ").append(getLevelColor(level)).append("\">").append(level).append("</td>")
                .append("<td>").append(clazz).append("</td>")
                .append("<td>").append(method).append("</td>")
                .append("<td>").append(thread).append("</td>")
                .append("<td>").append(message).append("</td>")
                .append("</tr>");
    }

    /**
     * Returns the color associated to the level of logging. Useful to display each level of logging in an appropriate
     * color.
     * @param level The logging level
     * @return The color associated to the logging level.
     */
    private static String getLevelColor(String level) {
        return switch (level) {
            case "OFF" -> "magenta";
            case "ALL", "CONFIG" -> "gray";
            case "INFO" -> "navy";
            case "WARNING" -> "orange";
            case "SEVERE" -> "red";
            case "FINE", "FINER", "FINEST" -> "olive";
            default -> "black";
        };
    }
}
