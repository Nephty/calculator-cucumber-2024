package calculator;

import back.calculator.types.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.*;

class TestRational {

    @Test
    void testConstructor() {
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        assertEquals(1, r.getNum());
        assertEquals(2, r.getDen());

        RationalValue r2 = new RationalValue(r, new IntValue(3));
        assertEquals(1, r2.getNum());
        assertEquals(6, r2.getDen());

        RationalValue r3 = new RationalValue(new IntValue(3), r);
        assertEquals(6, r3.getNum());
        assertEquals(1, r3.getDen());

        RationalValue r4 = new RationalValue(r, r2);
        assertEquals(3, r4.getNum());
        assertEquals(1, r4.getDen());
    }

    @Test
    void testReduce() {
        RationalValue r = new RationalValue(new IntValue(2), new IntValue(4));
        assertEquals(1, r.getNum());
        assertEquals(2, r.getDen());

        RationalValue r2 = new RationalValue(new IntValue(6), new IntValue(3));
        assertEquals(2, r2.getNum());
        assertEquals(1, r2.getDen());

        RationalValue r4 = new RationalValue(new IntValue(-4), new IntValue(8));
        assertEquals(-1, r4.getNum());
        assertEquals(2, r4.getDen());

        RationalValue r5 = new RationalValue(new IntValue(4), new IntValue(-8));
        assertEquals(-1, r5.getNum());
        assertEquals(2, r5.getDen());
    }


    @Test
    void testAdd() {
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        IntValue i = new IntValue(1);
        RationalValue r2 = (RationalValue) r.add(i);
        assertEquals(3, r2.getNum());
        assertEquals(2, r2.getDen());

        RationalValue r3 = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r4 = new RationalValue(new IntValue(1), new IntValue(3));
        RationalValue r5 = (RationalValue) r3.add(r4);
        assertEquals(5, r5.getNum());
        assertEquals(6, r5.getDen());

        RationalValue r6 = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r7 = new RationalValue(new IntValue(1), new IntValue(2));
        IntValue i2 = (IntValue) r6.add(r7);
        assertEquals(1, i2.getValue());

        RationalValue r8 = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));
        RealValue r9 = (RealValue) r8.add(real);
        assertEquals(new RealValue(new BigDecimal(1.0,new MathContext(5))), r9);
    }

    @Test
    void testSub() {
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r2 = new RationalValue(new IntValue(1), new IntValue(3));
        RationalValue r3 = (RationalValue) r.sub(r2);
        assertEquals(1, r3.getNum());
        assertEquals(6, r3.getDen());

        RationalValue r4 = new RationalValue(new IntValue(1), new IntValue(2));
        IntValue i = new IntValue(1);
        RationalValue r5 = (RationalValue) r4.sub(i);
        assertEquals(-1, r5.getNum());
        assertEquals(2, r5.getDen());

        RationalValue r6 = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r7 = new RationalValue(new IntValue(1), new IntValue(2));
        IntValue i2 = (IntValue) r6.sub(r7);
        assertEquals(0, i2.getValue());


        RationalValue r8 = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));
        RealValue r9 = (RealValue) r8.sub(real);
        assertEquals(new RealValue(new BigDecimal(0.0,new MathContext(5))), r9);
    }

    @Test
    void testMul() {
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r2 = new RationalValue(new IntValue(1), new IntValue(3));
        RationalValue r3 = (RationalValue) r.mul(r2);
        assertEquals(1, r3.getNum());

        RationalValue r4 = new RationalValue(new IntValue(1), new IntValue(2));
        IntValue i = new IntValue(2);
        IntValue i2 = (IntValue) r4.mul(i);
        assertEquals(1, i2.getValue());

        RationalValue r8 = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));
        RealValue r9 = (RealValue) r8.mul(real);
        assertEquals(new RealValue(new BigDecimal(0.25,new MathContext(5))), r9);
    }

    @Test
    void testDiv() {
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r2 = new RationalValue(new IntValue(1), new IntValue(3));
        RationalValue r3 = (RationalValue) r.div(r2);
        assertEquals(3, r3.getNum());
        assertEquals(2, r3.getDen());


        RationalValue r4 = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));
        RealValue r5 = (RealValue) r4.div(real);
        assertEquals(new RealValue(new BigDecimal(1.0,new MathContext(5))), r5);
    }

    @Test
    void testRealOperations(){
        RationalValue rational = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));

        assertEquals(real.sqrt(), rational.sqrt());
        assertEquals(real.cos(), rational.cos());
        assertEquals(real.sin(), rational.sin());
        assertEquals(real.ln(), rational.ln());
        assertEquals(real.exp(), rational.exp());
        assertEquals(real.atan(), rational.atan());
    }

    @Test
    void testEquals() {
        RationalValue r = new RationalValue(new IntValue(2), new IntValue(3));
        assertEquals(true, r.equals(r));

        RationalValue r2 = new RationalValue(new IntValue(2), new IntValue(3));
        assertEquals(false, r2.equals(new Object()));

        RationalValue r3 = new RationalValue(new IntValue(2), new IntValue(3));
        RationalValue r4 = new RationalValue(new IntValue(2), new IntValue(3));
        assertEquals(true, r3.equals(r4));

        RationalValue r5 = new RationalValue(new IntValue(2), new IntValue(3));
        RationalValue r6 = new RationalValue(new IntValue(3), new IntValue(2));
        assertEquals(false,r5.equals(r6));

        RationalValue r7 = new RationalValue(new IntValue(2), new IntValue(1));
        IntValue intValue = new IntValue(2);
        assertEquals(true, r7.equals(intValue));

        RationalValue r8 = new RationalValue(new IntValue(2), new IntValue(1));
        IntValue i = new IntValue(3);
        assertEquals(false,r8.equals(i));
    }

    @Test
    void testIsPositive(){
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        assertTrue(r.isPositive());

        RationalValue r2 = new RationalValue(new IntValue(-1), new IntValue(2));
        assertFalse(r2.isPositive());

        RationalValue r3 = new RationalValue(new IntValue(1), new IntValue(-2));
        assertFalse(r3.isPositive());

        RationalValue r4 = new RationalValue(new IntValue(-1), new IntValue(-2));
        assertTrue(r4.isPositive());
    }

    @Test
    void testConvertToReal(){
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        RealValue real = new RealValue(new BigDecimal(0.5,new MathContext(5)));
        assertEquals(real, r.convertToReal());
    }

    @Test
    void testMyNumberToReal(){
        MyNumber realNumber = new MyNumber(new RealValue(new BigDecimal(5)));
        MyNumber result = realNumber.convertToReal();
        assertEquals(realNumber, result);

        MyNumber imaginaryNumber = new MyNumber(new IntValue(0), new IntValue(5));
        MyNumber expected = new MyNumber(new RealValue(BigDecimal.ZERO), new RealValue(new BigDecimal(5)));
        MyNumber result2 = imaginaryNumber.convertToReal();
        assertEquals(expected, result2);

        MyNumber complexNumber = new MyNumber(new IntValue(3), new IntValue(4));
        MyNumber expected2 = new MyNumber(new RealValue(new BigDecimal(3)), new RealValue(new BigDecimal(4)));
        MyNumber result3 = complexNumber.convertToReal();
        assertEquals(expected2, result3);

        MyNumber notANumber = new NotANumber();
        MyNumber result4 = notANumber.convertToReal();
        assertTrue(result4 instanceof NotANumber);

        MyNumber rationalNumber = new MyNumber(new RationalValue(new IntValue(1), new IntValue(2)));
        MyNumber expected3 = new MyNumber(new RealValue(new BigDecimal(0.5)));
        MyNumber result5 = rationalNumber.convertToReal();
        assertEquals(expected3, result5);
    }

    @Test
    void testHashcode(){
        RationalValue r = new RationalValue(new IntValue(1), new IntValue(2));
        RationalValue r2 = new RationalValue(new IntValue(1), new IntValue(2));
        assertEquals(r.hashCode(), r2.hashCode());

        RationalValue r3 = new RationalValue(new IntValue(1), new IntValue(3));
        assertNotEquals(r.hashCode(), r3.hashCode());
    }

}
