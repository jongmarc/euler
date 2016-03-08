package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;

public class Problem012Test {

    @Test
    public void test() {
        assertEquals(1, new Problem012().highlyDivisibleTriangularNumber(1));
        assertEquals(3, new Problem012().highlyDivisibleTriangularNumber(2));
        assertEquals(6, new Problem012().highlyDivisibleTriangularNumber(4));
        assertEquals(28, new Problem012().highlyDivisibleTriangularNumber(5));
        assertEquals(28, new Problem012().highlyDivisibleTriangularNumber(6));
        assertEquals(1, new Problem012().betterHighlyDivisibleTriangularNumber(1));
        assertEquals(3, new Problem012().betterHighlyDivisibleTriangularNumber(2));
        assertEquals(6, new Problem012().betterHighlyDivisibleTriangularNumber(4));
        assertEquals(28, new Problem012().betterHighlyDivisibleTriangularNumber(5));
        assertEquals(28, new Problem012().betterHighlyDivisibleTriangularNumber(6));
 
    }

}
