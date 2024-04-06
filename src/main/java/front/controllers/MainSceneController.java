package front.controllers;

import back.calculator.App;
import back.calculator.Expression;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    Button clear;
    @FXML
    Button eight;
    @FXML
    Button nine;
    @FXML
    Button divide;
    @FXML
    Button closeParen;
    @FXML
    Button openParen;
    @FXML
    Button seven;
    @FXML
    Button multiply;
    @FXML
    Button six;
    @FXML
    Button five;
    @FXML
    Button four;
    @FXML
    Button minus;
    @FXML
    Button three;
    @FXML
    Button two;
    @FXML
    Button one;
    @FXML
    Button equals;
    @FXML
    Button add;
    @FXML
    Button dot;
    @FXML
    Button zero;

    @FXML
    Label lastExpression;
    @FXML
    Label lastExpression1;
    @FXML
    Label lastExpression2;
    @FXML
    Label lastExpression3;
    @FXML
    Label lastExpression4;
    @FXML
    Label lastResult;
    @FXML
    Label lastResult1;
    @FXML
    Label lastResult2;
    @FXML
    Label lastResult3;
    @FXML
    Label lastResult4;
    @FXML
    TextField outputField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the focus always on the textField
        Platform.runLater(() -> outputField.requestFocus());
        outputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (Boolean.FALSE.equals(newValue)) {
                outputField.requestFocus();
            }
        });
        outputField.setOnKeyPressed(event -> {
            if (Objects.requireNonNull(event.getCode()) == KeyCode.ENTER) {
                equalsButtonClicked();
            }
        });
    }

    @FXML
    // This method is called when the user clicks on a character button (Not C and =)
    public void characterButtonClicked(MouseEvent event) {
        Button source = (Button) event.getSource();

        if (source.equals(equals)) equalsButtonClicked();
        else if (source.equals(clear)) clearButtonClicked();
        else regularButtonClicked(event);
    }

    private void equalsButtonClicked() {
        App.setUserInput(outputField.getText());
        Expression result = App.evalUserInput();

        switchHistory(App.getUserInput(), result.toString());

        outputField.setText(result.toString());
        // Set the cursor at the end of the text
        outputField.positionCaret(outputField.getText().length());
        App.setUserInput("");
    }

    private void switchHistory(String newExpression, String newResult){
        Label[] expressionHistory = new Label[5];
        expressionHistory[0] = lastExpression; expressionHistory[1] = lastExpression1; expressionHistory[2] = lastExpression2; expressionHistory[3] = lastExpression3; expressionHistory[4] = lastExpression4;
        Label[] resultHistory = new Label[5];
        resultHistory[0] = lastResult; resultHistory[1] = lastResult1; resultHistory[2] = lastResult2; resultHistory[3] = lastResult3; resultHistory[4] = lastResult4;

        for(int i = 4; i > 0; i--){
            expressionHistory[i].setText(expressionHistory[i-1].getText());
            resultHistory[i].setText(resultHistory[i-1].getText());
        }
        expressionHistory[0].setText(newExpression);
        resultHistory[0].setText(newResult);
    }

    private void clearButtonClicked() {
        clearOutputField();
    }

    private void regularButtonClicked(MouseEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        int cursorPosition = outputField.getCaretPosition();
        outputField.insertText(cursorPosition, buttonText);
        App.setUserInput(outputField.getText());
        // Move the cursor to the right of the new character
        outputField.positionCaret(cursorPosition + 1);
    }

    private void clearOutputField() {
        outputField.setText("");
        App.setUserInput("");
    }
}
