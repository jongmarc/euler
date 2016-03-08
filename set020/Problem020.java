package nl.ramblings.euler.set020;
import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author Marco de Jong
 */
public class Problem020 {

    public static void main(String[] args) {
        Problem020 problem = new Problem020();
        long start = System.nanoTime();
        long result = problem.factorialDigitSum(100);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 20 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
    }

    public int factorialDigitSum(int factorial) {
        int result = 0;
        
        BigInteger big = factorial(factorial);
        for (char i: big.toString().toCharArray())
            result += i - 48;
        
        return result;
    }
    
    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++)
            result = result.multiply(new BigInteger("" + i));

        return result;
    }

}
