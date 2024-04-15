package front.controllers;

import back.converter.Units;
import front.scenes.Scenes;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.api.FxRobot;
import javafx.scene.control.*;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests for the GUI, more specifically the units converter feature.
 * This class contains the headless incompatible tests, skipped during the GitHub Actions.
 */
@ExtendWith(ApplicationExtension.class)
class HeadlessIncompatibleConverterGUITest extends ApplicationTest {
    private static Stage stage;

    /**
     * The id of the input field of the application where the user can input data to be taken into account in
     * computations.
     */
    private static final String inputFieldId = "#inputField";

    private Logger logger = LoggerFactory.getLogger(ConverterGUITest.class);

    /**
     * Will be called with {@code @Before} semantics, i.e. before each test method.
     *
     * @param stage_ - Will be injected by the test runner.
     */
    @Override
    public void start(Stage stage_) {
        stage = stage_;

        stage.setResizable(false);
        stage.setTitle("Amazing Calculator");
        stage.setScene(Scenes.CONVERTER_SCENE);
        stage.show();
    }

    @AfterEach
    void afterTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    /**
     * Helper for checkAvailableUnits with the speed units.
     */
    @Test
    void checkAvailableSpeedUnits(FxRobot robot) {
        System.out.println("new test\n========");
        List<String> expectedItems = Arrays.stream(Units.Speed.values())
                .map(Units.Unit::getSymbol)
                .toList();
        StringBuilder s = new StringBuilder();
        for (Object o : expectedItems) s.append(o.toString()).append(" ");
        logger.info(s.toString());
        System.out.println("s = " + s);
        checkAvailableUnits(robot, "#speedConversionModeItem", expectedItems);
    }

    /**
     * Helper for checkAvailableUnits with the weight units.
     */
    @Test
    void checkAvailableWeightUnits(FxRobot robot) {
        System.out.println("new test\n========");
        List<String> expectedItems = Arrays.stream(Units.Weight.values())
                .map(Units.Unit::getSymbol)
                .toList();
        StringBuilder s = new StringBuilder();
        for (Object o : expectedItems) s.append(o.toString()).append(" ");
        logger.info(s.toString());
        System.out.println("s = " + s);
        checkAvailableUnits(robot, "#weightConversionModeItem", expectedItems);
    }

    /**
     * Helper for checkAvailableUnits with the distance units.
     */
    @Test
    void checkAvailableDistanceUnits(FxRobot robot) {
        System.out.println("new test\n========");
        List<String> expectedItems = Arrays.stream(Units.Distance.values())
                .map(Units.Unit::getSymbol)
                .toList();
        StringBuilder s = new StringBuilder();
        for (Object o : expectedItems) s.append(o.toString()).append(" ");
        logger.info(s.toString());
        System.out.println("s = " + s);
        checkAvailableUnits(robot, "#distanceConversionModeItem", expectedItems);
    }

    /**
     * Helper for checkAvailableUnits with the time units.
     */
    @Test
    void checkAvailableTimeUnits(FxRobot robot) {
        System.out.println("new test\n========");
        List<String> expectedItems = Arrays.stream(Units.Time.values())
                .map(Units.Unit::getSymbol)
                .toList();
        StringBuilder s = new StringBuilder();
        for (Object o : expectedItems) s.append(o.toString()).append(" ");
        logger.info(s.toString());
        System.out.println("s = " + s);
        checkAvailableUnits(robot, "#timeConversionModeItem", expectedItems);
    }

    /**
     * Selects the unit type and triggers the verification of the available units.
     */
    private void checkAvailableUnits(FxRobot robot, String conversionModeItem, List<String> units) {
        try {
            selectConversionMode(conversionModeItem);
            verifyUnitSelectors(units);
        } catch (FxRobotException e) {
            fail();
        }
    }

    /**
     * Selects the unit type that we are going to verify (speed, weight...).
     */
    private void selectConversionMode(String conversionModeItem) {
        clickOn("#conversionModeSelector");
        clickOn(conversionModeItem);
        System.out.println("[FIX TESTS] clicked on " + conversionModeItem);
    }

    /**
     * Constructs three lists :
     *  - the expected units,
     *  - the units of the first unit selector and
     *  - the units of the second unit selector.
     *  Then, verifies that both unit selectors have all expected units available.
     * @param units The units of the enum that we are testing (example : Units.Speed.values()).
     */
    private void verifyUnitSelectors(List<String> units) {
        System.out.println("[FIX TESTS] entered verifyUnitSelectors");
        StringBuilder s = new StringBuilder();
        for (Object o : units) s.append(o.toString()).append(" ");
        logger.info(s.toString());
        System.out.println("s = " + s);



        MenuButton firstUnitSelector = lookup("#firstUnitSelector").query();
        List<String> firstSelectorItems = firstUnitSelector.getItems().stream()
                .map(MenuItem::getText)
                .collect(Collectors.toList());

        StringBuilder s1 = new StringBuilder();
        for (Object o : firstSelectorItems) s1.append(o.toString()).append(" ");
        logger.info(s1.toString());
        System.out.println("s1 = " + s1);



        MenuButton secondUnitSelector = lookup("#secondUnitSelector").query();
        List<String> secondSelectorItems = secondUnitSelector.getItems().stream()
                .map(MenuItem::getText)
                .collect(Collectors.toList());

        StringBuilder s2 = new StringBuilder();
        for (Object o : secondSelectorItems) s2.append(o.toString()).append(" ");
        logger.info(s2.toString());
        System.out.println("s2 = " + s2);

        Assertions.assertThat(firstSelectorItems).containsExactlyInAnyOrderElementsOf(units);
        Assertions.assertThat(secondSelectorItems).containsExactlyInAnyOrderElementsOf(units);
    }
}