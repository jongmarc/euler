package nl.ramblings.euler.set010;
/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 *
 * @author Marco de Jong
 */
public class Problem015 {

    public static void main(String[] args) {
        
        Problem015 problem = new Problem015();
        long start = System.nanoTime();
        long result = problem.countLatticePaths(20);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 15 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
    }

    public long countLatticePaths (int gridSize) {
        long[] grid = new long[gridSize + 1];

        for (int i = 0; i <= gridSize; i++)
            for (int j = i; j <= gridSize; j++)
                if (i == 0)                             // first row is filled with 1's
                    grid[j] = 1;
                else if (j == i)                        // starting point
                    grid[j] *= 2;
                else
                    grid[j] = grid[j] + grid[j-1];      // add the "grid above" with the previous one

        return grid[gridSize];
    }   
}
