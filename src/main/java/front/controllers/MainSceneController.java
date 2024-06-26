package front.controllers;

import back.calculator.App;
import back.calculator.ComplexForm;
import back.calculator.Expression;
import back.calculator.types.MyNumber;
import front.scenes.Scenes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    ComboBox<String> calculatorModeSelector;
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
    Button i;
    @FXML
    Button coma;
    @FXML
    Button modulus;
    @FXML
    Button eNotation;
    @FXML
    Button sqrt;
    @FXML
    Button ln;
    @FXML
    Button sin;
    @FXML
    Button cos;
    @FXML
    Button real;
    @FXML
    Button pi;
    @FXML
    Button exp;

    @FXML
    MenuButton formSelector;
    @FXML
    MenuItem cartesian;
    @FXML
    MenuItem polar;
    @FXML
    MenuItem exponential;

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
        // This method is called at the creation of the scene

        // At startup, the focus is set on the textField
        Platform.runLater(() -> outputField.requestFocus());

        // Add a listener that maintains the focus on the textField
        outputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (Boolean.FALSE.equals(newValue)) {
                outputField.requestFocus();
            }
        });

        // Set the equals button event
        outputField.setOnKeyPressed(event -> {
            if (Objects.requireNonNull(event.getCode()) == KeyCode.ENTER) {
                equalsButtonClicked();
            }
        });

        prepareCalculatorModeComboBox();
    }

    /**
     * Prepares the calculator mode combo box by giving it values (basic, conversion) and setting a
     * default value.
     */
    private void prepareCalculatorModeComboBox() {
        calculatorModeSelector.getItems().addAll(App.BASIC_MODE, App.CONVERSION_MODE);
        calculatorModeSelector.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(App.BASIC_MODE)) handleBasicModeSelected();
            else if (newValue.equals(App.CONVERSION_MODE)) handleConversionModeSelected();
        });
        calculatorModeSelector.setOnShowing(event -> calculatorModeSelector.setValue(App.BASIC_MODE));
    }

    /**
     * Switches to the basic view.
     * Note : this is untestable, since tests have their own stage that's separate from the stage in the App class.
     */
    @FXML
    private void handleBasicModeSelected() {
        App.setScene(Scenes.MAIN_SCENE);
    }

    /**
     * Stays on the converter view.
     * Note : this is untestable, since tests have their own stage that's separate from the stage in the App class.
     */
    @FXML
    private void handleConversionModeSelected() {
        App.setScene(Scenes.CONVERTER_SCENE);
    }

    @FXML
    public void characterButtonClicked(MouseEvent event) {
        // This method is called when the user clicks on a character button (Not C and =)

        Button source = (Button) event.getSource();

        if (source.equals(equals)) equalsButtonClicked();
        else if (source.equals(clear)) clearButtonClicked();
        else regularButtonClicked(event);
    }

    private void equalsButtonClicked() {
        // Read the input and evaluate it
        App.setUserInput(outputField.getText());
        Expression result = App.evalUserInput();

        // Log the new result on the GUI
        switchHistory(App.getUserInput(), result.toString());

        // Set the answer in the textField
        outputField.setText(result.toString());

        // Set the cursor at the end of the text
        outputField.positionCaret(outputField.getText().length());
    }

    @FXML
    private void realButtonClicked(MouseEvent event){
        App.setUserInput(outputField.getText());
        Expression result = App.evalUserInput();
        MyNumber resultNumber = (MyNumber) result;

        MyNumber realNumber = resultNumber.convertToReal();

        // Log the new result on the GUI
        switchHistory(App.getUserInput(), realNumber.toString());

        // Set the answer in the textField
        outputField.setText(realNumber.toString());

        // Set the cursor at the end of the text
        outputField.positionCaret(outputField.getText().length());
    }

    @FXML
    private void formSelected(ActionEvent event) {
        // This method is called when the user selects a form

        MenuItem source = (MenuItem) event.getSource();
        String form = source.getText();

        ComplexForm complexForm = ComplexForm.valueOf(form.toUpperCase());

        App.setUserInput(outputField.getText());
        Expression result = App.evalUserInput();
        MyNumber resultNumber = (MyNumber) result;
        resultNumber.setForm(complexForm);

        switchHistory(App.getUserInput(), resultNumber.toString());

        // Set the answer in the textField
        outputField.setText(resultNumber.toString());

        // Set the cursor at the end of the text
        outputField.positionCaret(outputField.getText().length());
    }

    private void switchHistory(String newExpression, String newResult){
        // This method logs the new result and shift last results

        Label[] expressionHistory = new Label[5];
        expressionHistory[0] = lastExpression; expressionHistory[1] = lastExpression1; expressionHistory[2] = lastExpression2; expressionHistory[3] = lastExpression3; expressionHistory[4] = lastExpression4;
        Label[] resultHistory = new Label[5];
        resultHistory[0] = lastResult; resultHistory[1] = lastResult1; resultHistory[2] = lastResult2; resultHistory[3] = lastResult3; resultHistory[4] = lastResult4;

        for(int index = 4; index > 0; index--){
            expressionHistory[index].setText(expressionHistory[index-1].getText());
            resultHistory[index].setText(resultHistory[index-1].getText());
        }
        expressionHistory[0].setText(newExpression);
        resultHistory[0].setText(newResult);
    }

    private void clearButtonClicked() {
        clearOutputField();
    }

    private void regularButtonClicked(MouseEvent event) {
        // This method handles character button pressed

        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (buttonText.equals("π")) {
            buttonText = "pi";
        } else if (buttonText.equals("e")) {
            buttonText = "exp";
        }

        int cursorPosition = outputField.getCaretPosition();
        outputField.insertText(cursorPosition, buttonText);
        App.setUserInput(outputField.getText());

        // Move the cursor to the right of the new character
        outputField.positionCaret(outputField.getText().length());
    }

    private void clearOutputField() {
        outputField.setText("");
        App.setUserInput("");
    }
}
