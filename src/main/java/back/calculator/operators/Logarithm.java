package back.calculator.operators;

import back.calculator.*;
import back.calculator.types.*;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents the arithmetic logarithm operation "ln".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 *
 * @see Operation
 * @see Minus
 * @see Times
 * @see Plus
 * @see Exponential
 * @see Sqrt
 * @see Divides
 * @see Sinus
 * @see Cosine
 * @see Modulus
 */
public class Logarithm extends Operation {

    public Logarithm(List<Expression> elist) throws IllegalConstruction {
        this(elist, null);
    }

    public Logarithm(List<Expression> elist, Notation n) throws IllegalConstruction {
        super(elist, n);
        if (elist.size() > 1)
            throw new IllegalConstruction();
        symbol = "ln";
        neutral = 0;
    }

    @Override
    public MyNumber op(MyNumber l, MyNumber r){
        throw new UnsupportedOperationException("Logarithm is a unary operator");
    }

    @Override
    public MyNumber op(MyNumber l){
        if (l instanceof NotANumber)
            return new NotANumber();
        if (l.getReal().isEqualsZero()) {
            Logger logger = Calculator.getLogger();
            if (logger.isErrorEnabled())
                logger.error("Logarithm of zero is undefined");
            return new NotANumber();
        }
        if (!l.getReal().isPositive())
            // = ln(|a|) + i arg(a) // Since a is negative, arg(a) = pi
            return new MyNumber(l.getReal().mul(new IntValue(-1)).ln(), new RealValue(new BigDecimal(Double.toString(Math.PI), App.getPrecision())));
        if (l.isImaginary()) {
            // ln(a + bi) = 1/2 ln(a^2 + b^2) + i atan(b/a)
            AbstractValue a = l.getReal();
            AbstractValue b = l.getImaginary();

            AbstractValue real = a.mul(a).add(b.mul(b)).ln().div(new IntValue(2));
            AbstractValue im = b.div(a).atan();

            return new MyNumber(real, im);
        }
        return new MyNumber(l.getReal().ln());
    }

    @Override
    public void addMoreParams(List<Expression> params) throws IllegalConstruction {
        super.addMoreParams(params);

        if (getArgs().size() > 1)
            throw new IllegalConstruction();
    }
}
