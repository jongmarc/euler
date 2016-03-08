package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem010Test {

    @Test
    public void testSummationOfPrimes() {
        assertEquals(0, new Problem010().summationOfPrimes(0));
        assertEquals(0, new Problem010().summationOfPrimes(1));
        assertEquals(2, new Problem010().summationOfPrimes(2));
        assertEquals(5, new Problem010().summationOfPrimes(3));
        assertEquals(5, new Problem010().summationOfPrimes(4));
        assertEquals(10, new Problem010().summationOfPrimes(5));
        assertEquals(10, new Problem010().summationOfPrimes(6));
        assertEquals(17, new Problem010().summationOfPrimes(7));
        assertEquals(17, new Problem010().summationOfPrimes(8));
        assertEquals(17, new Problem010().summationOfPrimes(9));
        assertEquals(17, new Problem010().summationOfPrimes(10));
        assertEquals(28, new Problem010().summationOfPrimes(11));
        assertEquals(28, new Problem010().summationOfPrimes(12));
        assertEquals(41, new Problem010().summationOfPrimes(13));
        assertEquals(41, new Problem010().summationOfPrimes(14));
        assertEquals(41, new Problem010().summationOfPrimes(15));
        assertEquals(41, new Problem010().summationOfPrimes(16));
        assertEquals(58, new Problem010().summationOfPrimes(17));
        assertEquals(58, new Problem010().summationOfPrimes(18));
        assertEquals(77, new Problem010().summationOfPrimes(19));
        assertEquals(77, new Problem010().summationOfPrimes(20));
        assertEquals(77, new Problem010().summationOfPrimes(21));
        assertEquals(77, new Problem010().summationOfPrimes(22));
        assertEquals(100, new Problem010().summationOfPrimes(23));
        assertEquals(100, new Problem010().summationOfPrimes(24));
        assertEquals(100, new Problem010().summationOfPrimes(25));
        assertEquals(1161, new Problem010().summationOfPrimes(102));
        assertEquals(5589, new Problem010().summationOfPrimes(240));
        assertEquals(13887, new Problem010().summationOfPrimes(400));
        assertEquals(26369, new Problem010().summationOfPrimes(570));
        assertEquals(43201, new Problem010().summationOfPrimes(735));
        assertEquals(64615, new Problem010().summationOfPrimes(915));
        assertEquals(76127, new Problem010().summationOfPrimes(1000));
    }
    
    @Test
    public void efficientTestSummationOfPrimes() {
        assertEquals(0, new Problem010().efficientSummationOfPrimes(0));
        assertEquals(0, new Problem010().efficientSummationOfPrimes(1));
        assertEquals(2, new Problem010().efficientSummationOfPrimes(2));
        assertEquals(5, new Problem010().efficientSummationOfPrimes(3));
        assertEquals(5, new Problem010().efficientSummationOfPrimes(4));
        assertEquals(10, new Problem010().efficientSummationOfPrimes(5));
        assertEquals(10, new Problem010().efficientSummationOfPrimes(6));
        assertEquals(17, new Problem010().efficientSummationOfPrimes(7));
        assertEquals(17, new Problem010().efficientSummationOfPrimes(8));
        assertEquals(17, new Problem010().efficientSummationOfPrimes(9));
        assertEquals(17, new Problem010().efficientSummationOfPrimes(10));
        assertEquals(28, new Problem010().efficientSummationOfPrimes(11));
        assertEquals(28, new Problem010().efficientSummationOfPrimes(12));
        assertEquals(41, new Problem010().efficientSummationOfPrimes(13));
        assertEquals(41, new Problem010().efficientSummationOfPrimes(14));
        assertEquals(41, new Problem010().efficientSummationOfPrimes(15));
        assertEquals(41, new Problem010().efficientSummationOfPrimes(16));
        assertEquals(58, new Problem010().efficientSummationOfPrimes(17));
        assertEquals(58, new Problem010().efficientSummationOfPrimes(18));
        assertEquals(77, new Problem010().efficientSummationOfPrimes(19));
        assertEquals(77, new Problem010().efficientSummationOfPrimes(20));
        assertEquals(77, new Problem010().efficientSummationOfPrimes(21));
        assertEquals(77, new Problem010().efficientSummationOfPrimes(22));
        assertEquals(100, new Problem010().efficientSummationOfPrimes(23));
        assertEquals(100, new Problem010().efficientSummationOfPrimes(24));
        assertEquals(100, new Problem010().efficientSummationOfPrimes(25));
        assertEquals(1161, new Problem010().efficientSummationOfPrimes(102));
        assertEquals(5589, new Problem010().efficientSummationOfPrimes(240));
        assertEquals(13887, new Problem010().efficientSummationOfPrimes(400));
        assertEquals(26369, new Problem010().efficientSummationOfPrimes(570));
        assertEquals(43201, new Problem010().efficientSummationOfPrimes(735));
        assertEquals(64615, new Problem010().efficientSummationOfPrimes(915));
        assertEquals(76127, new Problem010().efficientSummationOfPrimes(1000));
        

    }

}
