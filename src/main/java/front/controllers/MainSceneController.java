package front.controllers;

import back.calculator.App;
import back.calculator.Plus;
import back.calculator.MyNumber;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import back.calculator.IllegalConstruction;
import javafx.scene.input.MouseEvent;

public class MainSceneController {
    @FXML
    Button clear, eight, nine, divide, sqrt, pi, exp, closeParen, openParen, seven, x, multiply, six, five, four, minus, three, two, one, equals, add, percent, dot, zero;

    @FXML
    TextField outputField;

    @FXML
    // This method is called when the user clicks on a character button (Not C and =)
    public void characterButtonClicked(MouseEvent event) {
        Button source = (Button) event.getSource();

        if (source.equals(equals)) equalsButtonClicked(event);
        else if (source.equals(clear)) clearButtonClicked(event);
        else regularButtonClicked(event);
    }

    private void equalsButtonClicked(MouseEvent event) {
        try {
            // TODO : parse input and pass it to the Main.eval method
            MyNumber result = App.eval(new Plus(Arrays.asList(new MyNumber(1), new MyNumber(2))));
        } catch (IllegalConstruction e) {
            outputField.setText("Invalid operation.");
            e.printStackTrace();
        }
    }

    private void clearButtonClicked(MouseEvent event) {
        outputField.setText("");
        App.userInput = "";
    }

    private void regularButtonClicked(MouseEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        App.userInput += buttonText;
        outputField.setText(App.userInput);
    }
}
