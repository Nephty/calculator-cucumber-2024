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

class TestPrinter {

    private Calculator calc;
    private int value1, value2, value3;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 5;
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluatePrefix(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2), new MyNumber(value3));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+" -> assertEquals("+ (8, + (6, 5))", calc.format(new Plus(params), Notation.PREFIX));
                case "-" -> assertEquals("- (8, - (6, 5))", calc.format(new Minus(params), Notation.PREFIX));
                case "*" -> assertEquals("* (8, * (6, 5))", calc.format(new Times(params), Notation.PREFIX));
                case "/" -> assertEquals("/ (8, / (6, 5))", calc.format(new Divides(params), Notation.PREFIX));
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateInfix(String symbol){
        List <Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2), new MyNumber(value3));
        try{
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+" -> assertEquals("( 8 + ( 6 + 5 ) )", calc.format(new Plus(params), Notation.INFIX));
                case "-" -> assertEquals("( 8 - ( 6 - 5 ) )", calc.format(new Minus(params), Notation.INFIX));
                case "*" -> assertEquals("( 8 * ( 6 * 5 ) )", calc.format(new Times(params), Notation.INFIX));
                case "/" -> assertEquals("( 8 / ( 6 / 5 ) )", calc.format(new Divides(params), Notation.INFIX));
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testPrintPostfix(String symbol) {
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2), new MyNumber(value3));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+" -> assertEquals("(8, (6, 5) +) +", calc.format(new Plus(params), Notation.POSTFIX));
                case "-" -> assertEquals("(8, (6, 5) -) -", calc.format(new Minus(params), Notation.POSTFIX));
                case "*" -> assertEquals("(8, (6, 5) *) *", calc.format(new Times(params), Notation.POSTFIX));
                case "/" -> assertEquals("(8, (6, 5) /) /", calc.format(new Divides(params), Notation.POSTFIX));
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
