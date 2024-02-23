package visitor;

import calculator.Expression;
import calculator.MyNumber;
import calculator.Notation;
import calculator.Operation;

import java.util.ArrayList;

public class Diver extends Visitor {
    private int depth = 0;

    /**
     * Diver visitor constructor.
     */
    public Diver() {
    }

    /**
     * Use the visitor design pattern to visit a number.
     *
     * @param n The number being visited
     */
    @Override
    public void visit(MyNumber n) {
        this.depth = 0;
    }

    /**
     * Use the visitor design pattern to visit an operation
     * The operation is visited according to the notation set in the constructor.
     *
     * @param o The operation being visited
     */
    @Override
    public void visit(Operation o) {
        ArrayList<Integer> depths = new ArrayList<>();
        for (Expression expression : o.getArgs()) {
            expression.accept(this);
            depths.add(this.depth);
            System.out.print("Depth of sub-expression ");
            System.out.print(expression);
            System.out.print(" has been computed to be ");
            System.out.println(this.depth);
        }
        // Get max of the array list
        this.depth = max(depths) + 1;
        System.out.print("Depth of ");
        System.out.print(o);
        System.out.print(" has been computed to be ");
        System.out.println(this.depth);
    }
    /**
     * Depth getter
     *
     * @return The depth
     */
    public int getDepth() {
        return depth;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int max(ArrayList<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }
}
