package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem011Test {

    @Test
    public void test() {
        
        int[][] grid = new int[][] { {0,1,2}, {3,4,5},{6,7,8} };
        assertEquals(56, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(336, new Problem011().largestProductInGrid(grid, 3));

        grid = new int[][] { {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1} };
        assertEquals(1, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(1, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(1, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {9,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,9},{1,1,1,1},{1,1,1,1},{1,1,1,1} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,1},{1,1,9,1},{1,1,1,1},{1,1,1,1} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,1},{1,1,9,1},{1,1,1,1},{1,1,1,9} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(9, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,1},{1,1,1,1},{1,1,9,1},{1,1,1,9} };
        assertEquals(81, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,1},{1,9,1,1},{1,1,1,1},{1,1,1,9} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 4));

        grid = new int[][] { {1,1,1,1},{1,1,9,1},{1,1,1,1},{9,1,1,1} };
        assertEquals(9, new Problem011().largestProductInGrid(grid, 2));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 3));
        assertEquals(81, new Problem011().largestProductInGrid(grid, 4));
    }

}
