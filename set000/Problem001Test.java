package nl.ramblings.euler.set000;

import static org.junit.Assert.*;

import org.junit.Test;


public class Problem001Test {

    @Test
    public void test() {
        assertEquals(0, new Problem001().sumOfMultiplesOf3And5(0));
        assertEquals(0, new Problem001().sumOfMultiplesOf3And5(1));
        assertEquals(0, new Problem001().sumOfMultiplesOf3And5(2));
        assertEquals(3, new Problem001().sumOfMultiplesOf3And5(3));
        assertEquals(3, new Problem001().sumOfMultiplesOf3And5(4));
        assertEquals(8, new Problem001().sumOfMultiplesOf3And5(5));
        assertEquals(14, new Problem001().sumOfMultiplesOf3And5(6));
        assertEquals(14, new Problem001().sumOfMultiplesOf3And5(7));
        assertEquals(14, new Problem001().sumOfMultiplesOf3And5(8));
        assertEquals(23, new Problem001().sumOfMultiplesOf3And5(9));
    }

}
