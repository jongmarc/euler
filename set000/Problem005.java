package nl.ramblings.euler.set000;


/**
 * Problem 5 - Smallest multiple
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any 
 * remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Marco de Jong
 */
public class Problem005 {

    public static void main(String[] args) {
        Problem005 problem = new Problem005();
        long start = System.nanoTime();
        long result = problem.smallestMultiple(20);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 5 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientSmallestMultiple(20);
        stop = System.nanoTime();
        System.out.println("\nProblem 5 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }

    public long efficientSmallestMultiple(int maxNaturalNumber) {
        int result = 1;
        int pointer = 0;
        boolean check = true;
        int[] prime = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        int[] count = new int[prime.length];
        double limit = Math.sqrt(maxNaturalNumber);
        
        while (prime[pointer] <= maxNaturalNumber) {
            count[pointer] = 1;
            if (check)
                if (prime[pointer] <= limit)
                    count[pointer] = (int) Math.floor( Math.log(maxNaturalNumber) / Math.log(prime[pointer]) );
                else
                    check = false;

            result = result * (int)Math.pow(prime[pointer], count[pointer]);
            pointer = pointer + 1;
        }                    
        return result;
    }
    
    public long smallestMultiple(int maxNaturalNumber) {
        long upperbound = factorial(maxNaturalNumber);
        outerloop:
        for (long i = maxNaturalNumber; i <= upperbound; i++ ) {
            for (long j = maxNaturalNumber; j > 1; j-- )
                if (i % j != 0) {
                    continue outerloop;
                }
            return i;
        }
        return -1;
    }
        
    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;

        return result;
    }
    
}
