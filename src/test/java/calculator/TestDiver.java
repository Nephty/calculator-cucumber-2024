package calculator;

import back.calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestDiver {

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
     * No nesting : expressions such as 1 + 1 + 1
     */
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testNoNesting(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2), new MyNumber(value3));
        try {
            switch (symbol) {
                case "+" -> assertEquals(1, calc.depth(new Plus(params)));
                case "-" -> assertEquals(1, calc.depth(new Minus(params)));
                case "*" -> assertEquals(1, calc.depth(new Times(params)));
                case "/" -> assertEquals(1, calc.depth(new Divides(params)));
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    /**
     * Simple nesting : expressions such as ((1 + 1) + 1)
     *                                       ^^^^^^^   ^
     *                                simple nesting   simple nesting
     */
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testSimpleNesting(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            switch (symbol) {
                case "+" -> {
                    params = Arrays.asList(new Plus(params), new MyNumber(value3));
                    assertEquals(2, calc.depth(new Plus(params)));
                }
                case "-" -> {
                    params = Arrays.asList(new Minus(params), new MyNumber(value3));
                    assertEquals(2, calc.depth(new Minus(params)));
                }
                case "*" -> {
                    params = Arrays.asList(new Times(params), new MyNumber(value3));
                    assertEquals(2, calc.depth(new Times(params)));
                }
                case "/" -> {
                    params = Arrays.asList(new Divides(params), new MyNumber(value3));
                    assertEquals(2, calc.depth(new Divides(params)));
                }
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    /**
     * Multiple nesting : expressions such as ((1 + 1) + 1 + ((1 + 1) + 1))
     *                                         ^^^^^^^   ^   ^^^^^^^^^^^^^
     *                                  simple nesting   ^   multiple nesting
     *                                               no nesting
     */
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testMultipleNesting(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            switch (symbol) {
                case "+" -> {
                    params = Arrays.asList(new Plus(params), new MyNumber(value3));
                    params = Arrays.asList(new Plus(params), new MyNumber(value4));
                    assertEquals(3, calc.depth(new Plus(params)));
                }
                case "-" -> {
                    params = Arrays.asList(new Minus(params), new MyNumber(value3));
                    params = Arrays.asList(new Minus(params), new MyNumber(value4));
                    assertEquals(3, calc.depth(new Minus(params)));
                }
                case "*" -> {
                    params = Arrays.asList(new Times(params), new MyNumber(value3));
                    params = Arrays.asList(new Times(params), new MyNumber(value4));
                    assertEquals(3, calc.depth(new Times(params)));
                }
                case "/" -> {
                    params = Arrays.asList(new Divides(params), new MyNumber(value3));
                    params = Arrays.asList(new Divides(params), new MyNumber(value4));
                    assertEquals(3, calc.depth(new Divides(params)));
                }
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
