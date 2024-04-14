package back.calculator.types;

import back.calculator.App;

public class RationalValue extends AbstractValue {

    private int num;

    private int den;

    public RationalValue(AbstractValue num, AbstractValue den) {
        switch (num.getType()) {
            case INT:
                IntValue intNum = (IntValue) num;
                switch (den.getType()) {
                    case INT:
                        IntValue intDen = (IntValue) den;

                        this.num = intNum.getValue();
                        this.den = intDen.getValue();
                        break;

                    case RATIONAL:
                        // Invert the den and multiply the numerators
                        // 2 / (1/2) = 2 * (2/1)
                        RationalValue rationalDen = (RationalValue) den;

                        this.num = intNum.getValue() * rationalDen.getDen();
                        this.den = rationalDen.getNum();
                        break;
                }
                break;

            case RATIONAL:
                RationalValue rationalNum = (RationalValue) num;

                switch (den.getType()) {
                    case INT:
                        // Put the denominator to the numerator and make the multiplication with the numerator and the other denominator
                        // (1/2) / 2 = (2/1) * (1/2)
                        IntValue intDen = (IntValue) den;

                        this.num = rationalNum.getNum();
                        this.den = rationalNum.getDen() * intDen.getValue();
                        break;

                    case RATIONAL:
                        // Same as above but two multiplications
                        RationalValue rationalDen = (RationalValue) den;

                        this.num = rationalNum.getNum() * rationalDen.getDen();
                        this.den = rationalDen.getNum() * rationalNum.getDen();
                        break;
                }
        }
        this.setType(Type.RATIONAL);
        this.reduce();
    }

    private static int pgcd(int num, int den) {
        if (den == 0) {
            return num;
        } else {
            return pgcd(den, num % den);
        }
    }

    private void reduce(){
        int pgcd = pgcd(this.num, this.den);
        this.num = this.num / pgcd;
        this.den = this.den / pgcd;
        if (this.den < 0){
            this.den = - this.den;
            this.num = - this.num;
        }
    }

    @Override
    public AbstractValue add(AbstractValue other) {
        switch (other.getType()) {
            case INT:
                IntValue integer = (IntValue) other;
                int intNum2 = integer.getValue() * this.den;
                this.num += intNum2;
                break;
            case RATIONAL:
                RationalValue rational = (RationalValue) other;
                int ratNum2 = rational.getNum();
                int ratDen2 = rational.getDen();

                int oldDen = this.den;
                this.den = this.den * ratDen2;
                this.num = this.num * ratDen2 + oldDen * ratNum2;

        }
        this.reduce();
        if (this.den == 1) {
            return new IntValue(this.num);
        }
        return this;
    }

    @Override
    public AbstractValue sub(AbstractValue other) {
        switch (other.getType()) {
            case INT:
                IntValue integer = (IntValue) other;
                int intNum2 = integer.getValue() * this.den;
                this.num += intNum2;
                break;
            case RATIONAL:
                RationalValue rational = (RationalValue) other;
                int ratNum2 = rational.getNum();
                int ratDen2 = rational.getDen();

                int oldDen = this.den;
                this.den = this.den * ratDen2;
                this.num = this.num * ratDen2 - oldDen * ratNum2;
        }
        this.reduce();
        if (this.den == 1) {
            return new IntValue(this.num);
        }
        return this;
    }

    @Override
    public AbstractValue mul(AbstractValue other) {
        switch (other.getType()) {
            case INT:
                IntValue integer = (IntValue) other;
                this.num *= integer.getValue();
                break;
            case RATIONAL:
                RationalValue rational = (RationalValue) other;

                this.num *= rational.getNum();
                this.den *= rational.getDen();
        }
        this.reduce();
        if (this.den == 1) {
            return new IntValue(this.num);
        }
        return this;
    }

    @Override
    public AbstractValue div(AbstractValue other) {
        // TODO : Vérifier si le résultat est entier ??
        return new RationalValue(this, other);
    }

    @Override
    public AbstractValue sqrt() {
        // TODO : How to implement that ?
        // Change the App.RationalMode if sqrt is real ?
//        this.num = Math.sqrt(this.num);
//        this.den = Math.sqrt(this.den)
        return null;
    }

    public int getNum(){
        return this.num;
    }

    public int getDen(){
        return this.den;
    }

    @Override
    public boolean isEqualsZero() {
        return this.num == 0;
    }

    @Override
    public boolean isPositive() {
        return (this.num >= 0 & this.den >= 0);
    }

    @Override
    public String toString() {
        return this.num + "/" + this.den;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!((o instanceof IntValue) || o instanceof RationalValue)) return false;
        if (o instanceof IntValue) {
            IntValue intValue = (IntValue) o;
            return (this.num == intValue.getValue() & this.den == 1);
        } else{
            RationalValue rational = (RationalValue) o;
            return (this.num == rational.getNum() && this.den == rational.getDen());
        }
    }

    @Override
    public int hashCode() {
        // TODO : better solution ?
        return Float.hashCode(this.num / this.den);
    }
}