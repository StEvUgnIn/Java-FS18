package ex2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

    @Test
    void testToString () {
        Term actual = new Term(5, 5);
        String expected = "5x^5";
        assertEquals(expected, actual.toString());
        actual = new Term(-3, 3);
        expected = "- 3x^3";
        assertEquals(expected, actual.toString());
        actual = new Term(1, 1);
        expected = "x";
        assertEquals(expected, actual.toString());
        actual = new Term(0, 0);
        expected = "";
        assertEquals(expected, actual.toString());
        actual = new Term(-1, 0);
        expected = "- 1";
        assertEquals(expected, actual.toString());
    }
}