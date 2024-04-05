package back.calculator.types;

import back.calculator.Expression;
import back.calculator.Operation;
import back.visitor.Visitor;

/**
 * MyNumber is a concrete class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
public class MyNumber implements Expression {
    private final int real;

    private final int imaginary;

    /**
     * getter method to obtain the value contained in the object
     *
     * @return The integer number contained in the object
     */
    public int getReal() {
        return real;
    }

    /**
     * Getter method to obtain the imaginary part of the object
     *
     * @return The imaginary part of the object
     */
    public int getImaginary() {
        return imaginary;
    }


    /**
     * Constructor method
     *
     * @param v The integer value to be contained in the object
     */
    public MyNumber(int v) {
        real = v;
        imaginary = 0;
    }

    /**
     * Constructor method for complex numbers
     *
     * @param real The real part of the complex number
     * @param imaginary The imaginary part of the complex number
     */
    public MyNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Method to check if the number is imaginary
     *
     * @return True if the number is imaginary, false otherwise.
     */
    public boolean isImaginary() {
        return imaginary != 0;
    }

    /**
     * accept method to implement the visitor design pattern to traverse arithmetic expressions.
     * Each number will pass itself to the visitor object to get processed by the visitor.
     *
     * @param v The visitor object
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    /**
     * Convert a number into a String to allow it to be printed.
     *
     * @return The String that is the result of the conversion.
     */
    @Override
    public String toString() {
        if (isImaginary()) {
            return real + "+" + imaginary + "i";
        }
        return Integer.toString(real);
    }

    /**
     * Two MyNumber expressions are equal if the values they contain are equal
     *
     * @param o The object to compare to
     * @return A boolean representing the result of the equality test
     */
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof MyNumber)) {
            return false;
        }

        return real == ((MyNumber) o).real && imaginary == ((MyNumber) o).imaginary;
        // Used == since the contained value is a primitive value
        // If it had been a Java object, .equals() would be needed
    }

    /**
     * The method hashCode needs to be overridden it the equals method is overridden;
     * otherwise there may be problems when you use your object in hashed collections
     * such as HashMap, HashSet, LinkedHashSet.
     *
     * @return The result of computing the hash.
     */
    @Override
    public int hashCode() {
        if (isImaginary()) {
            return Integer.hashCode(real) + Integer.hashCode(imaginary);
        }
        return Integer.hashCode(real);
    }

}