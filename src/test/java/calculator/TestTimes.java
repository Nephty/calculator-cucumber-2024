package calculator;

//Import Junit5 libraries for unit testing:

import back.calculator.*;
import back.calculator.operators.Plus;
import back.calculator.operators.Times;
import back.calculator.types.MyNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTimes {

    private static final int VALUE_1 = 8;
    private static final int VALUE_2 = 6;
    private Times op;
    private List<Expression> params;

    @BeforeEach
    void setUp() {
        params = Arrays.asList(new MyNumber(VALUE_1), new MyNumber(VALUE_2));
        try {
            op = new Times(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new Times(null));
    }

    @Test
    void testConstructor2() {
        // A Plus expression should not be the same as a Times expression
        try {
            assertNotSame(op, new Plus(new ArrayList<>()));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should not be equal
        List<Expression> p = Arrays.asList(new MyNumber(VALUE_1), new MyNumber(VALUE_2));
        try {
            Times e = new Times(p, Notation.INFIX);
            assertEquals(op, e);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testNull() {
        assertDoesNotThrow(() -> op == null); // Direct way to test if the null case is handled.
    }

    @Test
    void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        List<Expression> p = Arrays.asList(new MyNumber(VALUE_1), new MyNumber(VALUE_2));
        try {
            Times e = new Times(p, Notation.INFIX);
            assertEquals(e.hashCode(), op.hashCode());
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new Times(params));
    }

}
