package back.calculator;

import javafx.application.Application;
import javafx.stage.Stage;

import front.scenes.SceneLoader;
import front.scenes.Scenes;

/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Software Engineering Lab
 * Faculty of Sciences
 *
 * @author tommens
 */
public class App extends Application {

    private static String userInput = "";

    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scenes.setMainScene(SceneLoader.load("MainScene.fxml"));
        stage.setResizable(false);
        stage.setTitle("Amazing Calculator");
        stage.setScene(Scenes.getMainScene());
        stage.show();
    }

    public static Expression evalUserInput() {
        return calculator.eval(calculator.read(App.userInput));
    }

    @SuppressWarnings("unused")
    public static String getUserInput() {
        return userInput;
    }

    public static void setUserInput(String userInput) {
        App.userInput = userInput;
    }
}
