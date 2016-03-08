package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem018Test {

    @Test
    public void testRowOfTriangularNumber() {
        assertEquals(1, new Problem018().rowOfTriangularNumber(1));
        assertEquals(2, new Problem018().rowOfTriangularNumber(3));
        assertEquals(3, new Problem018().rowOfTriangularNumber(6));
        assertEquals(4, new Problem018().rowOfTriangularNumber(10));
        assertEquals(5, new Problem018().rowOfTriangularNumber(15));
        assertEquals(6, new Problem018().rowOfTriangularNumber(21));
        assertEquals(7, new Problem018().rowOfTriangularNumber(28));
    }
    
    @Test
    public void testSumOfHighestPath() {
        assertEquals(4, new Problem018().sumOfHighestPath(new int[]{1,2,3}));
        assertEquals(5, new Problem018().sumOfHighestPath(new int[]{3,2,1}));
        assertEquals(10, new Problem018().sumOfHighestPath(new int[]{1,2,3,4,5,6}));
        assertEquals(23, new Problem018().sumOfHighestPath(new int[]{3,7,4,2,4,6,8,5,9,3}));
    }
}
