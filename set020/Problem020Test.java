package nl.ramblings.euler.set020;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem020Test {

    @Test
    public void test() {
        assertEquals(1, new Problem020().factorialDigitSum(0));
        assertEquals(1, new Problem020().factorialDigitSum(1));
        assertEquals(2, new Problem020().factorialDigitSum(2));
        assertEquals(6, new Problem020().factorialDigitSum(3));
        assertEquals(6, new Problem020().factorialDigitSum(4));
        assertEquals(27, new Problem020().factorialDigitSum(10));

    }

}
