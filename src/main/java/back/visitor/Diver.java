package back.visitor;

import back.calculator.Expression;
import back.calculator.types.MyNumber;
import back.calculator.Operation;

import java.util.ArrayList;

public class Diver extends Visitor {
    private int depth;

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
        }
        // Get max of the array list
        this.depth = max(depths) + 1;
    }

    /**
     * Depth getter
     *
     * @return The depth
     */
    public int getDepth() {
        return depth;
    }

    private int max(ArrayList<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }
}
