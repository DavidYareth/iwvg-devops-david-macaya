package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testFractionDefaultConstructor() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(4);
        assertEquals(4, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        fraction = new Fraction(1, 4);
        assertEquals(0.25, fraction.decimal(), 10e-5);
    }

    @Test
    void testIsProper() {
        assertTrue(fraction.isProper());

        fraction.setNumerator(4);
        fraction.setDenominator(3);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(fraction.isImproper());

        fraction.setNumerator(4);
        fraction.setDenominator(3);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(4, 6);
        assertTrue(fraction.isEquivalent(equivalentFraction));

        Fraction nonEquivalentFraction = new Fraction(3, 5);
        assertFalse(fraction.isEquivalent(nonEquivalentFraction));
    }

    @Test
    void testAdd() {
        Fraction anotherFraction = new Fraction(1, 3);
        Fraction result = Fraction.add(fraction, anotherFraction);

        assertEquals(3, result.getNumerator()); // 2/3 + 1/3 = 3/3 = 1
        assertEquals(3, result.getDenominator());

        anotherFraction = new Fraction(1, 4);
        result = Fraction.add(fraction, anotherFraction);

        assertEquals(11, result.getNumerator()); // 2/3 + 1/4 = 11/12
        assertEquals(12, result.getDenominator());
    }


    @Test
    void testMultiply() {
        Fraction anotherFraction = new Fraction(2, 5);
        Fraction result = Fraction.multiply(fraction, anotherFraction);

        assertEquals(4, result.getNumerator());
        assertEquals(15, result.getDenominator());
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=2, denominator=3}", fraction.toString());
    }
}
