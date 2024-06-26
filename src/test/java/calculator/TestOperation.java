package calculator;

//Import Junit5 libraries for unit testing:

import back.calculator.*;
import back.calculator.operators.Divides;
import back.calculator.operators.Minus;
import back.calculator.operators.Plus;
import back.calculator.types.MyNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestOperation {

    private Operation o;
    private Operation o2;

    @BeforeEach
    void setUp() throws Exception {
        List<Expression> params1 = Arrays.asList(new MyNumber(3), new MyNumber(4), new MyNumber(5));
        List<Expression> params2 = Arrays.asList(new MyNumber(5), new MyNumber(4));
        List<Expression> params3 = Arrays.asList(new Plus(params1), new Minus(params2), new MyNumber(7));
        o = new Divides(params3);
        o2 = new Divides(params3);
    }

    @Test
    void testEmptyConstructor(){
        assertThrows(IllegalConstruction.class, () -> o = new Divides(null));
    }

    @Test
    void testEquals() {
        assertEquals(o, o2);
    }

    @Test
    void testToStringEmpty() throws Exception {
        List<Expression> params = List.of();
        o = new Divides(params, Notation.PREFIX);

        assertEquals("/", o.toString());
        o.setNotation(Notation.INFIX);
        assertEquals("/", o.toString());
        o.setNotation(Notation.POSTFIX);
        assertEquals("/", o.toString());
    }

    @Test
    void testGetNotation() {
        assertEquals(Notation.INFIX, o.getNotation());
    }
}
