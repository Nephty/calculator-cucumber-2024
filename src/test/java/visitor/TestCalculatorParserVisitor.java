package visitor;


import back.calculator.Calculator;
import back.calculator.Expression;
import back.calculator.Notation;
import back.calculator.types.NotANumber;
import back.parser.calculatorParser;
import back.visitor.CalculatorParserVisitor;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCalculatorParserVisitor {

    private CalculatorParserVisitor visitor;
    private calculatorParser.IntAtomContext atom;

    private Calculator calc;

    private int value1, value2, value3;

    private final String[] mulDivOperators = {"*", "/"};

    private final String[] addSubOperators = {"+", "-"};

    @BeforeEach
    void setUp() {
        visitor = new CalculatorParserVisitor();

        atom = Mockito.mock(calculatorParser.IntAtomContext.class);
        TerminalNode node = Mockito.mock(TerminalNode.class);
        Mockito.when(node.getText()).thenReturn("5");
        Mockito.when(atom.NUMBER()).thenReturn(node);

        calc = new Calculator();
        value1 = 8;
        value2 = 6;
        value3 = 5;
    }


    @Test
    void testGetExpressionReturnsNotANumberForInvalidToken() {
        calculatorParser.MulDivInfixContext ctx = Mockito.mock(calculatorParser.MulDivInfixContext.class);
        Token token = Mockito.mock(Token.class);
        Mockito.when(token.getType()).thenReturn(-1);
        ctx.op = token;
        // Add params to ctx
        Mockito.when(ctx.getChild(0)).thenReturn(atom);
        Mockito.when(ctx.getChild(2)).thenReturn(atom);
        Token goodToken = Mockito.mock(Token.class);
        Mockito.when(goodToken.getType()).thenReturn(1);


        assertEquals(new NotANumber(), visitor.visitMulDivInfix(ctx));
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
        Expression e = calc.read("(" + expression + ")");
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
        Expression e = calc.read("(" + expression + ")");
        assertEquals(expression, calc.format(e, Notation.POSTFIX));
    }

    @Test
    void testWithSyntaxErrorShouldReturnNotANumber() {
        Expression e = calc.read("3 + 4 * ");
        assertEquals("NaN", calc.eval(e).toString());
    }
}
