package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;


public class Problem003Test {

    @Test
    public void testPrimeFactors() {
        Problem003 p = new Problem003();
        assertEquals(Arrays.asList(), p.primeFactors(1));
        assertEquals(Arrays.asList(2), p.primeFactors(2));
        assertEquals(Arrays.asList(3), p.primeFactors(3));
        assertEquals(Arrays.asList(2,2), p.primeFactors(4));
        assertEquals(Arrays.asList(5), p.primeFactors(5));
        assertEquals(Arrays.asList(2,3), p.primeFactors(6));
        assertEquals(Arrays.asList(7), p.primeFactors(7));
        assertEquals(Arrays.asList(2,2,2), p.primeFactors(8));
        assertEquals(Arrays.asList(3,3), p.primeFactors(9));
        assertEquals(Arrays.asList(2,5), p.primeFactors(10));
        assertEquals(Arrays.asList(11), p.primeFactors(11));
        assertEquals(Arrays.asList(2,2,3), p.primeFactors(12));
        assertEquals(Arrays.asList(2,2,2,3,5,11,13,19,29), p.primeFactors(2*2*2*3*5*11*13*19*29));
    }
    
    @Test
    public void largestPrimeFactor() {
        Problem003 p = new Problem003();  
        assertEquals(0, p.largestPrimeFactor(1));
        assertEquals(2, p.largestPrimeFactor(2));
        assertEquals(3, p.largestPrimeFactor(3));
        assertEquals(2, p.largestPrimeFactor(4));
        assertEquals(5, p.largestPrimeFactor(5));
        assertEquals(3, p.largestPrimeFactor(6));
        assertEquals(7, p.largestPrimeFactor(7));
        assertEquals(2, p.largestPrimeFactor(8));
        assertEquals(3, p.largestPrimeFactor(9));
        assertEquals(5, p.largestPrimeFactor(10));
        assertEquals(11, p.largestPrimeFactor(11));
        assertEquals(3, p.largestPrimeFactor(12));
    }
    
    @Test
    public void testBigPrimeFactors() {
        Problem003 p = new Problem003();
        assertEquals(Arrays.asList(), p.primeFactors(new BigInteger("1")));
        assertEquals(Arrays.asList(new BigInteger("2")), p.primeFactors(new BigInteger("2")));
        assertEquals(Arrays.asList(new BigInteger("3")), p.primeFactors(new BigInteger("3")));
        assertEquals(Arrays.asList(new BigInteger("2"),new BigInteger("2")), p.primeFactors(new BigInteger("4")));
        assertEquals(Arrays.asList(new BigInteger("5")), p.primeFactors(new BigInteger("5")));
        assertEquals(Arrays.asList(new BigInteger("2"),new BigInteger("3")), p.primeFactors(new BigInteger("6")));
        assertEquals(Arrays.asList(new BigInteger("7")), p.primeFactors(new BigInteger("7")));
        assertEquals(Arrays.asList(new BigInteger("2"),new BigInteger("2"),new BigInteger("2")), p.primeFactors(new BigInteger("8")));
        assertEquals(Arrays.asList(new BigInteger("3"),new BigInteger("3")), p.primeFactors(new BigInteger("9")));
        assertEquals(Arrays.asList(new BigInteger("2"),new BigInteger("5")), p.primeFactors(new BigInteger("10")));
        assertEquals(Arrays.asList(new BigInteger("11")), p.primeFactors(new BigInteger("11")));
        assertEquals(Arrays.asList(new BigInteger("2"),new BigInteger("2"),new BigInteger("3")), p.primeFactors(new BigInteger("12")));
    }
    
    @Test
    public void largestBigPrimeFactor() {
        Problem003 p = new Problem003();  
        assertEquals(new BigInteger("0"), p.largestPrimeFactor(new BigInteger("1")));
        assertEquals(new BigInteger("2"), p.largestPrimeFactor(new BigInteger("2")));
        assertEquals(new BigInteger("3"), p.largestPrimeFactor(new BigInteger("3")));
        assertEquals(new BigInteger("2"), p.largestPrimeFactor(new BigInteger("4")));
        assertEquals(new BigInteger("5"), p.largestPrimeFactor(new BigInteger("5")));
        assertEquals(new BigInteger("3"), p.largestPrimeFactor(new BigInteger("6")));
        assertEquals(new BigInteger("7"), p.largestPrimeFactor(new BigInteger("7")));
        assertEquals(new BigInteger("2"), p.largestPrimeFactor(new BigInteger("8")));
        assertEquals(new BigInteger("3"), p.largestPrimeFactor(new BigInteger("9")));
        assertEquals(new BigInteger("5"), p.largestPrimeFactor(new BigInteger("10")));
        assertEquals(new BigInteger("11"), p.largestPrimeFactor(new BigInteger("11")));
        assertEquals(new BigInteger("3"), p.largestPrimeFactor(new BigInteger("12")));
    }
}
