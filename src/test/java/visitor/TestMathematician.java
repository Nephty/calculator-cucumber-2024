package visitor;

import back.calculator.*;
import back.calculator.operators.Divides;
import back.calculator.operators.Minus;
import back.calculator.operators.Plus;
import back.calculator.operators.Times;
import back.calculator.types.MyNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestMathematician {

    private Calculator calc;
    private int value1, value2, value3;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 5;
    }

    /**
     * Test the evaluation of the numbers count in an expression
     */
    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testNumbersCount(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            switch (symbol) {
                case "+" -> {
                    params = Arrays.asList(new Plus(params), new MyNumber(value3));
                    assertEquals(3, calc.numbersCount(new Plus(params)));
                }
                case "-" -> {
                    params = Arrays.asList(new Minus(params), new MyNumber(value3));
                    assertEquals(3, calc.numbersCount(new Minus(params)));
                }
                case "*" -> {
                    params = Arrays.asList(new Times(params), new MyNumber(value3));
                    assertEquals(3, calc.numbersCount(new Times(params)));
                }
                case "/" -> {
                    params = Arrays.asList(new Divides(params), new MyNumber(value3));
                    assertEquals(3, calc.numbersCount(new Divides(params)));
                }
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
