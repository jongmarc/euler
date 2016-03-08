package nl.ramblings.euler.set000;

/** 
 * Project Euler.net - Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Marco de Jong
 */

public class Problem001 {
    
    public int sumOfMultiplesOf3And5(int maxNaturalNumber) {
        int result = 0;
        for (int i = 0; i <= maxNaturalNumber; i++)
            if (i % 3 == 0 || i % 5 == 0)
                result += i;
        return result;
    }
    public int efficientSumOfMultiplesOf3And5(int maxNaturalNumber) {
        int p = maxNaturalNumber / 3;
        int n3 = 3 * ( p * ( p + 1 ) ) / 2;
        p = maxNaturalNumber / 5;
        int n5 = 5 * ( p * ( p + 1 ) ) / 2;
        p = maxNaturalNumber / 15;
        int n15 = 15 * ( p * ( p + 1 ) ) / 2;
        return n3 + n5 - n15;
    }

    public static void main(String[] args) {
        Problem001 problem = new Problem001();
        long start = System.nanoTime();
        long result = problem.sumOfMultiplesOf3And5(999);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 1 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientSumOfMultiplesOf3And5(999);
        stop = System.nanoTime();
        System.out.println("\nProblem 1 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }
    
}
