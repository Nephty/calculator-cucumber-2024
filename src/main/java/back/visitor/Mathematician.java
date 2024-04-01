package back.visitor;

import back.calculator.Expression;
import back.calculator.MyNumber;
import back.calculator.Operation;

public class Mathematician extends Visitor {
    private int numbersCount = 0;

    /**
     * Use the visitor design pattern to visit a number.
     *
     * @param n The number being visited
     */
    @Override
    public void visit(MyNumber n) {
        this.numbersCount += 1;
    }

    /**
     * Use the visitor design pattern to visit an operation
     * The operation is visited according to the notation set in the constructor.
     *
     * @param o The operation being visited
     */
    @Override
    public void visit(Operation o) {
        for (Expression a : o.getArgs()) {
            a.accept(this);
        }
    }

    /**
     * Depth getter
     *
     * @return The depth
     */
    public int getNumbersCount() {
        return numbersCount;
    }
}
