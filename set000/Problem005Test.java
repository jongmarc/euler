package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem005Test {

    @Test
    public void test() {
        assertEquals(1, new Problem005().smallestMultiple(1));
        assertEquals(2, new Problem005().smallestMultiple(2));
        assertEquals(6, new Problem005().smallestMultiple(3));
        assertEquals(12, new Problem005().smallestMultiple(4));
        assertEquals(60, new Problem005().smallestMultiple(5));
        assertEquals(2520, new Problem005().smallestMultiple(10));

    }

}
