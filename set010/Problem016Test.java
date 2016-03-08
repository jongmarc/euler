package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem016Test {

    @Test
    public void test() {
        assertEquals(4, new Problem016().powerDigitSum(2));
        assertEquals(8, new Problem016().powerDigitSum(3));
        assertEquals(7, new Problem016().powerDigitSum(4));
        assertEquals(26, new Problem016().powerDigitSum(15));
        
    }

}
