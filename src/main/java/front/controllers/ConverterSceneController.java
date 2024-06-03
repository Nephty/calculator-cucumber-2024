package front.controllers;

import back.calculator.App;
import back.calculator.types.MyNumber;
import back.calculator.types.RealValue;
import back.converter.UnitClassStringConverter;
import back.converter.UnitStringConverter;
import back.converter.Units;
import front.scenes.Scenes;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ConverterSceneController implements Initializable {
    @FXML
    ComboBox<String> calculatorModeSelector;
    @FXML
    ComboBox<Units.Unit> firstUnitSelector;
    @FXML
    ComboBox<Units.Unit> secondUnitSelector;
    @FXML
    ComboBox<Class<? extends Units.Unit>> conversionModeSelector;

    @FXML
    Button clear;
    @FXML
    Button nine;
    @FXML
    Button eight;
    @FXML
    Button seven;
    @FXML
    Button six;
    @FXML
    Button five;
    @FXML
    Button four;
    @FXML
    Button three;
    @FXML
    Button two;
    @FXML
    Button one;
    @FXML
    Button zero;
    @FXML
    Button equals;
    @FXML
    Button dot;

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
    TextField inputField;

    /**
     * Contains all available unit types (Speed, Weight...) as classes.
     */
    private ObservableList<Class<? extends Units.Unit>> conversionModes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // At startup, the focus is set on the textField
        Platform.runLater(() -> inputField.requestFocus());

        // Add a listener that maintains the focus on the textField
        inputField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (Boolean.FALSE.equals(newValue)) {
                inputField.requestFocus();
            }
        });

        // Set the equals button event
        inputField.setOnKeyPressed(event -> {
            if (Objects.requireNonNull(event.getCode()) == KeyCode.ENTER) {
                equalsButtonClicked();
            }
        });

        // Prepare combo boxes
        prepareCalculatorModeComboBox();
        prepareConversionModeComboBox();
        prepareComboBoxConverters();

        // Set listener for selection changes
        conversionModeSelector.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(Units.Speed.class)) handleSpeedConversionSelected();
            else if (newValue.equals(Units.Weight.class)) handleWeightConversionSelected();
            else if (newValue.equals(Units.Distance.class)) handleDistanceConversionSelected();
            else if (newValue.equals(Units.Time.class)) handleTimeConversionSelected();
            else if (newValue.equals(Units.Angles.class)) handleAngleConversionSelected();
        });
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
        calculatorModeSelector.setOnShowing(event -> calculatorModeSelector.setValue(App.CONVERSION_MODE));
    }

    /**
     * Prepares the conversion mode combo box by giving it values (unit types (speed, weight...)) and setting a
     * default value.
     */
    private void prepareConversionModeComboBox() {
        conversionModes.addAll(Units.getUnitClasses());
        conversionModeSelector.setItems(conversionModes);
        conversionModeSelector.setValue(conversionModes.get(0)); // Set default
        handleSpeedConversionSelected(); // Set units for default
    }

    /**
     * Set converters for all three combo boxes in order to "beautiful display" the values of these combo boxes.
     */
    private void prepareComboBoxConverters() {
        conversionModeSelector.setConverter(new UnitClassStringConverter());
        firstUnitSelector.setConverter(new UnitStringConverter());
        secondUnitSelector.setConverter(new UnitStringConverter());
    }

    /**
     * Called when clicking on a button.
     */
    @FXML
    public void characterButtonClicked(MouseEvent event) {
        Button source = (Button) event.getSource();

        if (source.equals(equals)) equalsButtonClicked();
        else if (source.equals(clear)) clearButtonClicked();
        else regularButtonClicked(event);
    }

    /**
     * Handles the behavior that the app should have when the equals button is clicked.
     */
    private void equalsButtonClicked() {
        Units.Unit firstUnit = firstUnitSelector.getValue();
        Units.Unit secondUnit = secondUnitSelector.getValue();
        MyNumber result = App.convert(new RealValue(new BigDecimal(inputField.getText(), App.getPrecision())), firstUnit, secondUnit);
        String resultString = result.toString();
        switchHistory(inputField.getText() + firstUnit.getSymbol(), resultString + secondUnit.getSymbol());
        inputField.setText(resultString);
        // Move the cursor to the end of the text
        inputField.positionCaret(inputField.getText().length());
    }

    /**
     * Handles the behavior that the app should have when any button but the equals button and the clear
     * button are clicked.
     */
    private void regularButtonClicked(MouseEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();


        int cursorPosition = inputField.getCaretPosition();
        inputField.insertText(cursorPosition, buttonText);
        App.setUserInput(inputField.getText());
        inputField.positionCaret(cursorPosition + 1);
    }

    /**
     * Handles the behavior that the app should have when the clear button is clicked.
     */
    private void clearButtonClicked() {
        clearInputField();
    }

    /**
     * This method clears the input field.
     */
    private void clearInputField() {
        inputField.setText("");
    }

    /**
     * Shift history and enter a new result
     *
     * @param newExpression The input expression
     * @param newResult     The result of the input expression
     */
    private void switchHistory(String newExpression, String newResult) {
        Label[] expressionHistory = new Label[5];
        expressionHistory[0] = lastExpression;
        expressionHistory[1] = lastExpression1;
        expressionHistory[2] = lastExpression2;
        expressionHistory[3] = lastExpression3;
        expressionHistory[4] = lastExpression4;
        Label[] resultHistory = new Label[5];
        resultHistory[0] = lastResult;
        resultHistory[1] = lastResult1;
        resultHistory[2] = lastResult2;
        resultHistory[3] = lastResult3;
        resultHistory[4] = lastResult4;

        for (int i = 4; i > 0; i--) {
            expressionHistory[i].setText(expressionHistory[i - 1].getText());
            resultHistory[i].setText(resultHistory[i - 1].getText());
        }
        expressionHistory[0].setText(newExpression);
        resultHistory[0].setText(newResult);
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

    /**
     * Defines the conversion as a conversion of speed. Sets the appropriate available units in the menus and set the
     * texts of the menus accordingly.
     */
    @FXML
    private void handleSpeedConversionSelected() {
        Units.Speed[] values = Units.Speed.values();
        replaceSelectorItems(firstUnitSelector, values);
        replaceSelectorItems(secondUnitSelector, values);
        firstUnitSelector.setValue(Units.Speed.METERS_PER_SECOND);
        secondUnitSelector.setValue(Units.Speed.METERS_PER_SECOND);
    }

    /**
     * Defines the conversion as a conversion of weight. Sets the appropriate available units in the menus and set the
     * texts of the menus accordingly.
     */
    @FXML
    private void handleWeightConversionSelected() {
        Units.Weight[] values = Units.Weight.values();
        replaceSelectorItems(firstUnitSelector, values);
        replaceSelectorItems(secondUnitSelector, values);
        firstUnitSelector.setValue(Units.Weight.GRAM);
        secondUnitSelector.setValue(Units.Weight.GRAM);
    }

    /**
     * Defines the conversion as a conversion of distance. Sets the appropriate available units in the menus and set the
     * texts of the menus accordingly.
     */
    @FXML
    private void handleDistanceConversionSelected() {
        Units.Distance[] values = Units.Distance.values();
        replaceSelectorItems(firstUnitSelector, values);
        replaceSelectorItems(secondUnitSelector, values);
        firstUnitSelector.setValue(Units.Distance.METER);
        secondUnitSelector.setValue(Units.Distance.METER);
    }

    /**
     * Defines the conversion as a conversion of time. Sets the appropriate available units in the menus and set the
     * texts of the menus accordingly.
     */
    @FXML
    private void handleTimeConversionSelected() {
        Units.Time[] values = Units.Time.values();
        replaceSelectorItems(firstUnitSelector, values);
        replaceSelectorItems(secondUnitSelector, values);
        firstUnitSelector.setValue(Units.Time.SECOND);
        secondUnitSelector.setValue(Units.Time.SECOND);
    }

    /**
     * Defines the conversion as a conversion of angles. Sets the appropriate available units in the menus and set the
     * texts of the menus accordingly.
     */
    @FXML
    private void handleAngleConversionSelected() {
        Units.Angles[] values = Units.Angles.values();
        replaceSelectorItems(firstUnitSelector, values);
        replaceSelectorItems(secondUnitSelector, values);
        firstUnitSelector.setValue(Units.Angles.DEGREE);
        secondUnitSelector.setValue(Units.Angles.DEGREE);
    }

    /**
     * Replaces the items of the given selector by the given values.
     * @param selector The selector of which the items must be replaced.
     * @param values The values to put in that selector.
     */
    private void replaceSelectorItems(ComboBox<Units.Unit> selector, Units.Unit[] values) {
        selector.getItems().clear();
        for (Units.Unit unit : values) {
            selector.getItems().add(unit);
        }
    }
}
