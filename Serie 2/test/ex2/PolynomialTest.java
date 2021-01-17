package ex2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void add () {
        Polynomial p1, p2, actual, expected;
        p1 = new Polynomial(5, 4, 3, 2, 1, 0);
        p2 = new Polynomial(1, 1, 1, 1, 1, 1);
        expected = new Polynomial(6, 5, 4, 3, 2, 1);
        actual = p1.add(p2);
        assertEquals(expected, actual);
    }

    @Test
    void multiply () {
        Polynomial p1;
        Polynomial p2;
        Polynomial actual;
        Object expected;
        p1 = new Polynomial(5, 4, 3, 2, 1, 0);
        p2 = new Polynomial(0, 0, 0, 0, 0, 0);
        expected = p2.clone();
        actual = p1.multiply(p2);
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        Polynomial p1 = new Polynomial(5, 4, 3, 2, 1);
        String expected = "5x^4 + 4x^3 + 3x^2 + 2x + 1";
        assertEquals(expected, p1.toString());
    }
}