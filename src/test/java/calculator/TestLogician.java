package calculator;

import back.calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestLogician {

    private Calculator calc;
    private int value1, value2, value3, value4;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 5;
        value4 = 7;
    }

    /**
     * Test the evaluation of the numbers count in an expression
     */
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testOperationsCount(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            switch (symbol) {
                case "+" -> {
                    params = Arrays.asList(new Plus(params), new MyNumber(value3));
                    assertEquals(2, calc.operationsCount(new Plus(params)));
                }
                case "-" -> {
                    params = Arrays.asList(new Minus(params), new MyNumber(value3));
                    assertEquals(2, calc.operationsCount(new Minus(params)));
                }
                case "*" -> {
                    params = Arrays.asList(new Times(params), new MyNumber(value3));
                    assertEquals(2, calc.operationsCount(new Times(params)));
                }
                case "/" -> {
                    params = Arrays.asList(new Divides(params), new MyNumber(value3));
                    assertEquals(2, calc.operationsCount(new Divides(params)));
                }
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
