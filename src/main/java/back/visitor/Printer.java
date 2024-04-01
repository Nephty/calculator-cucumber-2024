package back.visitor;

import back.calculator.MyNumber;
import back.calculator.Notation;
import back.calculator.Operation;

import java.util.stream.IntStream;

public class Printer extends Visitor {
    private Notation notation = Notation.INFIX;
    private String computedValue = "";

    /**
     * Custom notation constructor.
     *
     * @param notation The custom notation to use
     */
    public Printer(Notation notation) {
        this.notation = notation;
    }

    /**
     * Default INFIX constructor.
     */
    public Printer() {
    }

    /**
     * Notation setter.
     * @param notation The notation to use
     */
    public void setNotation(Notation notation) {
        this.notation = notation;
    }

    /**
     * Use the visitor design pattern to visit a number.
     * @param n The number being visited
     */
    @Override
    public void visit(MyNumber n) {
        this.computedValue = n.toString();
    }

    /**
     * Use the visitor pattern to visit an operation.
     * The operation is handled differently according to its notation.
     * @param o The operation being visited
     */
    @Override
    public void visit(Operation o){
        StringBuilder bobTheBuilder = new StringBuilder();
        switch(notation){
            case INFIX -> handleInfix(o, bobTheBuilder);
            case PREFIX -> handlePrefix(o, bobTheBuilder);
            case POSTFIX -> handlePostfix(o, bobTheBuilder);
        }
        this.computedValue = bobTheBuilder.toString();
    }

    /**
     * This method is set to handle the printing of and Infix notation.
     * @param o the operation to be printed
     * @param bobTheBuilder the string builder that will contain the string representing the operation
     */
    public void handleInfix(Operation o, StringBuilder bobTheBuilder){
        var ref = new Object() {
            int index = o.getArgs().size() - 1;
        };
        // for each expression in the operation we append it to the builder
        o.getArgs().forEach(expression -> {
            expression.accept(this);
            // If it's not the last expression then we call the generic method according to the notation
            if(ref.index >= 1){
                appendInfixExpression(bobTheBuilder, computedValue, o.getSymbol());
                ref.index--;
            }
            // If it is the last expression then we call the specific method according to the notation
            else if(ref.index == 0){
                appendInfixLastOperand(bobTheBuilder, computedValue, o.getArgs().size());
            }
        });
    }

    /**
     * This method is set to handle the printing of and Prefix notation.
     * @param o the operation to be printed
     * @param bobTheBuilder the string builder that will contain the string representing the operation
     */
    public void handlePrefix(Operation o, StringBuilder bobTheBuilder){
        var ref = new Object(){
            int index = o.getArgs().size() - 1;
        };
        // for each expression in the operation we append it to the builder
        o.getArgs().forEach(expression -> {
            expression.accept(this);
            // If it's not the last expression then we call the generic method according to the notation
            if(ref.index >= 1){
                appendPrefixExpression(bobTheBuilder, computedValue, o.getSymbol());
                ref.index--;
            }
            // If it is the last expression then we call the specific method according to the notation
            else if(ref.index == 0){
                appendPrefixLastOperand(bobTheBuilder, computedValue, o.getArgs().size());
            }
        });
    }

    /**
     * This method is set to handle the printing of and Postfix notation.
     * @param o the operation to be printed
     * @param bobTheBuilder the string builder that will contain the string representing the operation
     */

    public void handlePostfix(Operation o, StringBuilder bobTheBuilder){
        var ref = new Object(){
            int index = o.getArgs().size() - 1;
        };
        o.getArgs().forEach(expression -> {
            expression.accept(this);
            // If it's not the last expression then we call the generic method according to the notation
            if (ref.index >= 1){
                appendPostfixExpression(bobTheBuilder, computedValue);
                ref.index--;
            }
            // If it is the last expression then we call the specific method according to the notation
            // It is a bit different for Postfix as all symbols are part of the tail of the expression
            else if(ref.index == 0){
                appendPostfixLastOperand(bobTheBuilder, computedValue, o.getArgs().size(), o.getSymbol());
            }
        });

    }

    /**
     * Method to append values and symbols according to Infix notation
     * @param bobTheBuilder the string builder to append the expression to
     * @param value the value to append
     * @param symbol the symbol to append
     */
    private void appendInfixExpression(StringBuilder bobTheBuilder, String value, String symbol) {
        bobTheBuilder.append("( ").append(value).append(' ').append(symbol).append(' ');
    }

    /**
     * Method to append values and symbols according to Prefix notation
     * @param bobTheBuilder the string builder to append the expression to
     * @param value the value to append
     * @param symbol the symbol to append
     */
    private void appendPrefixExpression(StringBuilder bobTheBuilder, String value, String symbol){
        bobTheBuilder.append(symbol).append(" (").append(value).append(", ");
    }

    /**
     * Method to append values and symbols according to Postfix notation
     * @param bobTheBuilder The string builder to append the expression to
     * @param value the value to append
     */
    private void appendPostfixExpression(StringBuilder bobTheBuilder, String value){
        bobTheBuilder.append('(').append(value).append(", ");
    }

    /**
     * Method to append the last elements of an Infix operation
     * @param bobTheBuilder the string builder to append the expression to
     * @param value the value to append
     * @param size the size of the operation to know how to end it
     */
    private void appendInfixLastOperand(StringBuilder bobTheBuilder, String value, int size) {
        bobTheBuilder.append(value);
        IntStream.range(0, size-1).forEach(i -> bobTheBuilder.append(" )"));
    }

    /**
     * Method to append the last elements of a Prefix operation
     * @param bobTheBuilder the string builder to append the expression to
     * @param value the value to append
     * @param size the size of the operation to know how to end it
     */
    private void appendPrefixLastOperand(StringBuilder bobTheBuilder, String value, int size){
        bobTheBuilder.append(value);
        IntStream.range(0, size-1).forEach(i -> bobTheBuilder.append(')'));
    }

    /**
     * Method to append the last elements of a Postfix operation
     * @param bobTheBuilder the string builder to append the expression to
     * @param value the value to append
     * @param size the size of the operation to know how to end it
     * @param symbol the symbol to add at the end of the operation as it should be in postfix
     */
    private void appendPostfixLastOperand(StringBuilder bobTheBuilder, String value, int size, String symbol){
        bobTheBuilder.append(value).append(')');
        IntStream.range(0, size-2).forEach(i -> bobTheBuilder.append(' ').append(symbol).append(')'));
        bobTheBuilder.append(' ').append(symbol);
    }
    /**
     * Notation getter
     * @return The notation used
     */
    public Notation getNotation() {
        return notation;
    }

    /**
     * Computed value getter
     * @return The computed value
     */
    public String getComputedValue() {
        return computedValue;
    }
}
