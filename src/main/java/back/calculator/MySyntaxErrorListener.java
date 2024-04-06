package back.calculator;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

/**
 * MySyntaxErrorListener is a custom error listener that extends the BaseErrorListener class to handle syntax errors.
 *
 * <p>
 *     We created this class to have custom error messages and more importantly to be able to detect syntax errors easily. <br>
 *     When a syntax error is detected, we set the hasSyntaxError flag to true and store the error message.
 * </p>
 */
public class MySyntaxErrorListener extends BaseErrorListener {
    private boolean hasError;

    private String message;

    /**
     * Getter method to check if a syntax error has been detected
     * @return True if a syntax error has been detected, false otherwise
     */
    public boolean hasSyntaxError() {
        return hasError;
    }

    /**
     * Getter method to get the error message. <br>
     * The message is formatted as follows:
     * <pre>{@code
     *    Syntax Error!
     *    Token "token" (line x, column y) message
     *    Rule stack: [rule1, rule2, ...]
     * }</pre>
     * @return The error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Method to handle syntax errors detected by the parser.
     * @param recognizer The parser that detected the error
     * @param offendingSymbol The token that caused the error
     * @param line The line where the error occurred
     * @param charPositionInLine The column where the error occurred
     * @param msg The error message
     * @param e The exception that caused the error
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        hasError = true;

        // Change the error message
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        message = "Syntax Error!\n" +
                "Token \"" + ((Token) offendingSymbol).getText() + "\" (line " + line +
                ", column " + (charPositionInLine + 1) + ") " + msg + "\n" +
                "Rule stack: " + stack;

    }
}
