package back.calculator;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import back.parser.calculatorLexer;
import back.parser.calculatorParser;
import back.visitor.CalculatorParserVisitor;

/**
 * Main class for the parser of the calculator. It uses the ANTLR4 library to parse the input. <br>
 * The parser is generated from the grammar defined in the calculator.g4 file.
 *
 * <p>
 *     The grammar handles prefix, infix and postfix notations. {@see parser.calculator.g4}
 * </p>
 *
 *     Example of expressions:
 *     <pre>{@code
 *         infix op infix
 *         op '(' prefix ',' prefix ')'
 *         '(' postfix ',' postfix ')' op
 *     }</pre>
 */
public class ExpressionParser {


    /**
     * Parse a String and return the corresponding expression.
     *
     * <p>
     *     If there is a syntax error in the input, an IllegalConstruction exception is thrown
     *     and the error message is logged.
     * </p>
     *
     * @param expression String to parse
     * @return The corresponding expression object representing the input
     * @throws IllegalConstruction If there is a syntax error in the input
     */
    public Expression parse(String expression) throws IllegalConstruction {
        CharStream input = CharStreams.fromString(expression);
        calculatorLexer lexer = new calculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        calculatorParser parser = new calculatorParser(tokens);

        parser.removeErrorListeners(); // Remove the default error listeners
        MySyntaxErrorListener errorListener = new MySyntaxErrorListener();
        parser.addErrorListener(errorListener); // Add our custom error listener

        ParseTree tree = parser.prog();

        if (errorListener.hasSyntaxError()) {
            // Report the syntax error
            // TODO: Log the error message here
            System.err.println(errorListener.getMessage());
            throw new IllegalConstruction();
        }

        CalculatorParserVisitor visitor = new CalculatorParserVisitor();
        return visitor.visit(tree);
    }
}
