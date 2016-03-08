package nl.ramblings.euler.set020;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Problem021Test {

    @Test
    public void test() {
        ArrayList<Integer> checkA = new ArrayList<Integer>();
        checkA.add(1);        
        assertEquals(checkA, new Problem021().properDivisor(1));
        assertEquals(checkA, new Problem021().properDivisor(2));
        checkA.remove(new Integer(2));
        checkA.add(2);
        assertEquals(checkA, new Problem021().properDivisor(4));
        checkA.remove(new Integer(4));
        checkA.remove(new Integer(2));
        assertEquals(checkA, new Problem021().properDivisor(3));
        
        int sumOfThisNumber = 0;
        for (Integer divisor:   new Problem021().properDivisor(284))
            sumOfThisNumber += divisor;

        System.out.println(sumOfThisNumber);
        
        assertEquals(7, new Problem021().SumOfProperDivisors(4));
        assertEquals(6, new Problem021().SumOfProperDivisors(5));

    }

}
