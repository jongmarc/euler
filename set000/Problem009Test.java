package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem009Test {

    @Test
    public void test() {
        assertEquals(60, new Problem009().specialPythagoreanTriplet(12));
        assertEquals(60, new Problem009().efficientSpecialPythagoreanTriplet(12));
    }

}
