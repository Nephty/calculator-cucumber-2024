package back.calculator.types;

import back.calculator.App;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Represents a real number. It extends AbstractValue.
 * It uses BigDecimal to store the value.
 */

public class RealValue extends AbstractValue{

    private final /* BigDecimal value of the object */BigDecimal value;

    private final /* The precision of the object*/ MathContext precision;

    /**
     * Constructor for a real number.
     * @param value The BigDecimal value.
     */
    public RealValue(BigDecimal value) {
        this.value = value;
        type = Type.REAL;
        this.precision = App.getPrecision();
    }

    public BigDecimal getValue() {
        return value.stripTrailingZeros();
    }

    /**
     * Add a value to this value. <br/>
     * The result will be a new RealValue object.
     * @param other The other value to add to the current value of the object.
     * @return The result of the addition stored in a new object.
     */
    @Override
    public AbstractValue add(AbstractValue other) {
        return switch(other.getType()) {
            case INT -> new RealValue(this.value.add(new BigDecimal(((IntValue) other).getValue(), this.precision), this.precision));
            case RATIONAL -> new RealValue(this.value.add(new BigDecimal(((RationalValue) other).getNum()).divide(new BigDecimal(((RationalValue) other).getDen()), this.precision)));
            default -> new RealValue(this.value.add(((RealValue) other).value, this.precision));
        };
    }
    /**
     * Subtract a value from this value. <br/>
     * The result will be a new RealValue object.
     * @param other The other value to subtract from the current value of the object.
     * @return The result of the subtraction stored in a new object.
     */
    @Override
    public AbstractValue sub(AbstractValue other) {
        return switch (other.getType()) {
            case INT ->
                    new RealValue(this.value.subtract(new BigDecimal(((IntValue) other).getValue()), this.precision));
            case RATIONAL ->
                    new RealValue(this.value.subtract(new BigDecimal(((RationalValue) other).getNum()).divide(new BigDecimal(((RationalValue) other).getDen()), this.precision)));
            default -> new RealValue(this.value.subtract(((RealValue) other).value, this.precision));
        };
    }

    /**
     * Multiply a value with this value. <br/>
     * The result will be a new RealValue object.
     * @param other The value to multiply with the current value of the object.
     * @return The result of the multiplication stored in a new object.
     */
    @Override
    public AbstractValue mul(AbstractValue other) {
        return switch (other.getType()) {
            case INT -> new RealValue(this.value.multiply(new BigDecimal(((IntValue) other).getValue()), this.precision));
            case RATIONAL -> new RealValue(this.value.multiply(new BigDecimal(((RationalValue) other).getNum()).divide(new BigDecimal(((RationalValue) other).getDen()), this.precision)));
            default -> new RealValue(this.value.multiply(((RealValue) other).value, this.precision));
        };
    }

    /**
     * Divide this value by another value. <br/>
     * The result will be a new RealValue object.
     * @param other The value to divide the current value of the object by.
     * @return The result of the division stored in a new object.
     */
    @Override
    public AbstractValue div(AbstractValue other) {
        return switch (other.getType()) {
            case INT -> new RealValue(this.value.divide(new BigDecimal(((IntValue) other).getValue()), this.precision));
            case RATIONAL -> new RealValue(this.value.divide(new BigDecimal(((RationalValue) other).getNum()).divide(new BigDecimal(((RationalValue) other).getDen()), this.precision), this.precision));
            default -> new RealValue(this.value.divide(((RealValue) other).value, this.precision));
        };
    }

    /**
     * Computes the square root of the value.
     * The result will be a new RealValue object.
     * @return The square root of the value stored in a new object.
     */
    @Override
    public AbstractValue sqrt() {
        return new RealValue(this.value.sqrt(this.precision));
    }

    /**
     * Computes the cosinus of the value.
     * @return The cosinus of the value stored in a new object.
     */
    @Override
    public AbstractValue cos() {
        double doubleValue = this.value.doubleValue();
        BigDecimal cos = new BigDecimal(Double.toString(Math.cos(doubleValue)), this.precision);
        return new RealValue(cos);
    }

    /**
     * Computes the sinus of the value.
     * @return The sinus of the value stored in a new object.
     */
    @Override
    public AbstractValue sin() {
       double longValue = this.value.doubleValue();
       BigDecimal sin = new BigDecimal(Double.toString(Math.sin(longValue)), this.precision);
       return new RealValue(sin);
    }

    /**
     * Computes the neperian logarithm of the value.
     * @return The neperian logarithm of the value stored in a new object.
     */
    @Override
    public AbstractValue ln() {
        BigDecimal lnValue = new BigDecimal(Double.toString(Math.log(this.value.doubleValue())), this.precision);
        return new RealValue(lnValue);
    }

    /**
     * Computes the neperian constant e to the power of this value.
     * @return The result of the operation stored in a new object.
     */
    @Override
    public AbstractValue exp() {
        BigDecimal eValue = new BigDecimal(Double.toString(Math.exp(this.value.intValue())), this.precision);
        return new RealValue(eValue);
    }

    /**
     * Computes the arctangent of the value.
     * @return The arctangent of the value stored in a new object.
     */
    @Override
    public AbstractValue atan() {
        BigDecimal atanValue = new BigDecimal(Double.toString(Math.atan(this.value.doubleValue())), this.precision);
        return new RealValue(atanValue);
    }


    @Override
    public boolean isEqualsZero() {
        return this.value.compareTo(BigDecimal.ZERO) == 0;
    }

    @Override
    public boolean isPositive() {
        return this.value.compareTo(BigDecimal.ZERO) >= 0;
    }

    @Override
    public String toString() {
        return this.value.stripTrailingZeros().toString();
    }

    /**
     * Compare the object value with another object value.
     * @param o The object to compare to.
     * @return True if the values are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this.value.equals(o)){
            return true;
        }
        if (!(o instanceof RealValue realValue)){
            return false;
        }
        return (this.value).stripTrailingZeros().compareTo(realValue.value.stripTrailingZeros()) == 0;
    }

    /**
     * Compute the hashcode of the real value.
     * @return The hashcode of the real value.
     */
    @Override
    public int hashCode() {
        return (this.value.hashCode());
    }
}

