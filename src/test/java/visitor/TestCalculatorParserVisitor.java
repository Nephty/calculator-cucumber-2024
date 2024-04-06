package visitor;


import back.calculator.Calculator;
import back.calculator.Expression;
import back.calculator.Notation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCalculatorParserVisitor {

    private Calculator calc;

    private int value1, value2, value3;

    private final String[] mulDivOperators = {"*", "/"};

    private final String[] addSubOperators = {"+", "-"};

    @BeforeEach
    void setUp() {
        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 5;
    }

    @Test
    void testParseMulDivInfix() {
        for (String operator : mulDivOperators) {
            String expression = "( " + value1 + " " + operator + " ( " + value2 + " " + operator + " " + value3 + " ) )";
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.INFIX));
        }
    }

    @Test
    void testParseAddSubInfix() {
        for (String operator : addSubOperators) {
            String expression = "( " + value1 + " " + operator + " ( " + value2 + " " + operator + " " + value3 + " ) )";
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.INFIX));
        }
    }

    @Test
    void testParseMulDivPrefix() {
        for (String operator : mulDivOperators) {
            String expression = operator + " (" + value1 + ", " + operator + " (" + value2 + ", " + value3 + "))";
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.PREFIX));
        }
    }

    @Test
    void testParseAddSubPrefix() {
        for (String operator : addSubOperators) {
            String expression = operator + " (" + value1 + ", " + operator + " (" + value2 + ", " + value3 + "))";
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.PREFIX));
        }
    }

    @Test
    void testParseParensPrefix() {
        String expression = "/ (2, 5)";
        Expression e = calc.read("("+expression+")");
        assertEquals(expression, calc.format(e, Notation.PREFIX));
    }

    @Test
    void testParseMulDivPostfix() {
        for (String operator : mulDivOperators) {
            String expression = "(" + value1 + ", (" + value2 + ", " + value3 + ") " + operator + ") " + operator;
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.POSTFIX));
        }
    }

    @Test
    void testParseAddSubPostfix() {
        for (String operator : addSubOperators) {
            String expression = "(" + value1 + ", (" + value2 + ", " + value3 + ") " + operator + ") " + operator;
            Expression e = calc.read(expression);
            assertEquals(expression, calc.format(e, Notation.POSTFIX));
        }
    }

    @Test
    void testParseParensPostfix() {
        String expression = "(2, 5) /";
        Expression e = calc.read("("+expression+")");
        assertEquals(expression, calc.format(e, Notation.POSTFIX));
    }

    @Test
    void testWithSyntaxErrorShouldReturnNotANumber() {
        Expression e = calc.read("3 + 4 * ");
        assertEquals("NaN", calc.eval(e).toString());
    }
}
