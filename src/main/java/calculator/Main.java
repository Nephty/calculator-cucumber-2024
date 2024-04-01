package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Software Engineering Lab
 * Faculty of Sciences
 *
 * @author tommens
 */
public class Main {

    /**
     * This is the main method of the application.
     * It provides examples of how to use it to construct and evaluate arithmetic expressions.
     *
     * @param args Command-line parameters are not used in this version
     */
    public static void main(String[] args) {

        Expression e;
        Calculator c = new Calculator();

        try {
            e = new MyNumber(8);
            c.print(e);
            c.eval(e);

            List<Expression> params = new ArrayList<>();
            Collections.addAll(params, new MyNumber(3), new MyNumber(4), new MyNumber(5));
            e = new Plus(params, Notation.PREFIX);
            c.printExpressionDetails(e);
            c.eval(e);

            List<Expression> params2 = new ArrayList<>();
            Collections.addAll(params2, new MyNumber(5), new MyNumber(3));
            e = new Minus(params2, Notation.INFIX);
            c.print(e);
            c.eval(e);

            List<Expression> params3 = new ArrayList<>();
            Collections.addAll(params3, new Plus(params), new Minus(params2));
            e = new Times(params3);
            c.printExpressionDetails(e);
            c.eval(e);

            List<Expression> params4 = new ArrayList<>();
            Collections.addAll(params4, new Plus(params), new Minus(params2), new MyNumber(5));
            e = new Divides(params4, Notation.POSTFIX);
            c.print(e);
            c.eval(e);
        } catch (IllegalConstruction exception) {
            System.out.println("cannot create operations without parameters");
        }

        System.out.println("================= Parser ====================");
        Expression parsedExpression = c.read("3 + 4");
        c.print(parsedExpression); // = 7

        Expression parsedExpression2 = c.read("3 + 4 * 5");
        c.print(parsedExpression2); // = 23

        Expression parsedExpression3 = c.read("(3 + 4) * 5");
        c.print(parsedExpression3); // = 35

        Expression parsedExpression4 = c.read("+ (3 4)");
        c.print(parsedExpression4); // = 7

        Expression parsedExpression5 = c.read("+ (3, 4)");
        c.print(parsedExpression5); // = 7

        Expression parsedExpression6 = c.read("+ (3, 4, 5)");
        c.print(parsedExpression6); // = 12

        Expression parsedExpression7 = c.read("(3 4 5) +");
        c.print(parsedExpression7); // = 12
    }

}
