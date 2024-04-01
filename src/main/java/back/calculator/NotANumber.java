package back.calculator;


/**
 * NotANumber is a subclass of MyNumber. NaN represent a result of an arithmetic expression
 * which leads to a non-determined scenario.
 * For example, when an expression tries to divide a number by zero, it returns an instance of NotANumber.
 *
 * @see MyNumber
 */
public class NotANumber extends MyNumber {

    /**
     * Constructor method
     */
    public NotANumber() {
        super(-1);
    }


    /**
     * Converts a NotANumber instance to a "NaN" string.
     *
     * @return The "NaN" string
     */
    @Override
    public String toString() {
        return "NaN";
    }
}
