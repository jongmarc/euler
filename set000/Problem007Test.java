package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem007Test {

    @Test
    public void test() {
        assertEquals(-1, new Problem007().findNthPrime(0));
        assertEquals(2, new Problem007().findNthPrime(1));
        assertEquals(3, new Problem007().findNthPrime(2));
        assertEquals(5, new Problem007().findNthPrime(3));
        assertEquals(7, new Problem007().findNthPrime(4));
        assertEquals(11, new Problem007().findNthPrime(5));
        assertEquals(13, new Problem007().findNthPrime(6));
        assertEquals(17, new Problem007().findNthPrime(7));
        assertEquals(19, new Problem007().findNthPrime(8));
        assertEquals(23, new Problem007().findNthPrime(9));
        assertEquals(29, new Problem007().findNthPrime(10));
        assertEquals(31, new Problem007().findNthPrime(11));
        assertEquals(37, new Problem007().findNthPrime(12));
        assertEquals(41, new Problem007().findNthPrime(13));
        assertEquals(43, new Problem007().findNthPrime(14));
        assertEquals(47, new Problem007().findNthPrime(15));
        assertEquals(53, new Problem007().findNthPrime(16));
        assertEquals(59, new Problem007().findNthPrime(17));
        assertEquals(61, new Problem007().findNthPrime(18));
        assertEquals(67, new Problem007().findNthPrime(19));
        assertEquals(71, new Problem007().findNthPrime(20));
        assertEquals(73, new Problem007().findNthPrime(21));
        assertEquals(79, new Problem007().findNthPrime(22));
        assertEquals(83, new Problem007().findNthPrime(23));
        assertEquals(89, new Problem007().findNthPrime(24));
        assertEquals(97, new Problem007().findNthPrime(25));
    }

}
