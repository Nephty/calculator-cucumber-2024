package calculator;

import back.calculator.Expression;
import back.calculator.IllegalConstruction;
import back.calculator.Notation;
import back.calculator.operators.Modulus;
import back.calculator.types.MyNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TestModulus {

    private static final int REAL = 3;
    private static final int IMAGINARY = 4;
    private Modulus op;

    @BeforeEach
    void setUp() {
        List<Expression> params = List.of(new MyNumber(REAL, IMAGINARY));
        try {
            op = new Modulus(params);
        } catch (IllegalConstruction e) {
            fail("Error during Modulus creation");
        }
    }

    @Test
    void testConstructor1ShouldThrowWhenEmptyParameters() {
        // It should not be possible to create a Plus expression with null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new Modulus(null));
    }

    @Test
    void testConstructor2ShouldThrowWhenMoreThanOneParameter() {
        // It should not be possible to create a Plus expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new Modulus(List.of(new MyNumber(1), new MyNumber(2))));
    }

    @Test
    void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        ArrayList<Expression> p = new ArrayList<>(List.of(new MyNumber(REAL, IMAGINARY)));
        try {
            Modulus e = new Modulus(p, Notation.INFIX);
            assertEquals(op, e);
            assertEquals(e, e);
            assertNotEquals(e, new Modulus(new ArrayList<>(List.of(new MyNumber(IMAGINARY, REAL))), Notation.INFIX));
        } catch (IllegalConstruction e) {
            fail("Error during Modulus creation in test");
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testNull() {
        assertDoesNotThrow(() -> op == null); // Direct way to test if the null case is handled.
    }

    @Test
    void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        ArrayList<Expression> p = new ArrayList<>(List.of(new MyNumber(REAL, IMAGINARY)));
        try {
            Modulus e = new Modulus(p, Notation.INFIX);
            assertEquals(e.hashCode(), op.hashCode());
        } catch (IllegalConstruction e) {
            fail("Error during Modulus creation in test");
        }
    }

    @Test
    void testOpWith2ParametersShouldThrow() {
        MyNumber a = new MyNumber(1);
        MyNumber b = new MyNumber(2);
        // It should not be possible to call op with 2 parameters
        assertThrows(UnsupportedOperationException.class, () -> op.op(a, b));
    }

    @Test
    void testAddMoreParamsResultingInMoreThanOneParameter() {
        // It should not be possible to add more parameters to a Modulus expression
        assertThrows(IllegalConstruction.class, () -> op.addMoreParams(List.of(new MyNumber(1))));
    }



}
