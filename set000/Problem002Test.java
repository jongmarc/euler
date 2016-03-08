package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem002Test {

    @Test
    public void test() {
        assertEquals(0, new Problem002().sumOfEvenFibonacciNumbers(0));
        assertEquals(0, new Problem002().sumOfEvenFibonacciNumbers(1));
        assertEquals(2, new Problem002().sumOfEvenFibonacciNumbers(2));
        assertEquals(2, new Problem002().sumOfEvenFibonacciNumbers(3));
        assertEquals(2, new Problem002().sumOfEvenFibonacciNumbers(4));
        assertEquals(10, new Problem002().sumOfEvenFibonacciNumbers(8));
        assertEquals(10, new Problem002().sumOfEvenFibonacciNumbers(13));
        assertEquals(10, new Problem002().sumOfEvenFibonacciNumbers(21));
        assertEquals(10, new Problem002().sumOfEvenFibonacciNumbers(33));
        assertEquals(44, new Problem002().sumOfEvenFibonacciNumbers(34));
        assertEquals(44, new Problem002().sumOfEvenFibonacciNumbers(35));
        assertEquals(44, new Problem002().sumOfEvenFibonacciNumbers(143));
        assertEquals(188, new Problem002().sumOfEvenFibonacciNumbers(144));
        assertEquals(188, new Problem002().sumOfEvenFibonacciNumbers(145));

    }

}
