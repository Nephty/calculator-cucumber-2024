package back.calculator;

import back.calculator.types.MyNumber;
import back.calculator.types.RealValue;
import back.converter.Converter;
import back.converter.Units;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import front.scenes.Scenes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.MathContext;


/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Software Engineering Lab
 * Faculty of Sciences
 *
 * @author tommens
 * @author LicorneRose7
 * @author frix
 * @author ThomasBernard28
 * @author Nephty
 */
public class App extends Application {
    /**
     * Static variable holding the stage of the application. Refer to this variable for any stage modification.
     */
    private static Stage stage;

    private static String userInput = "";

    public static final String BASIC_MODE = "Basic";
    public static final String CONVERSION_MODE = "Conversion";

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Static variable holding the precision of the calculator used for RealValue construction using BigDecimal.
     */
    private static MathContext precision = new MathContext(5);

    private static final Calculator CALCULATOR = new Calculator();

    public static void main(String[] args) {
        LOGGER.info("Starting the application");
        launch(args);
        LOGGER.info("Application stopped");
    }

    @Override
    public void start(Stage s) {
        stage = s; // NOSONAR
        stage.setResizable(false);
        stage.setTitle("Amazing Calculator");
        setScene(Scenes.MAIN_SCENE);
        stage.show();
    }

    /**
     * Set the currently displayed scene.
     * Usage : <code>setScene(Scenes.YOUR_SCENE);</code>
     * @param scene The scene to display
     */
    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    @SuppressWarnings("unused")
    public static void setPrecision(int precision) {
        App.precision = new MathContext(precision);
    }

    public static MathContext getPrecision() {
        return App.precision;
    }

    public static Expression evalUserInput() {
        return CALCULATOR.eval(CALCULATOR.read(App.userInput));
    }

    public static String getUserInput() {
        return userInput;
    }

    public static void setUserInput(String userInput) {
        App.userInput = userInput;
    }

    public static Logger getLogger() {
        return LOGGER;
    }


    public static MyNumber convert(RealValue value, Units.Unit from, Units.Unit to) {
        return Converter.convert(value, from, to);
    }
}
