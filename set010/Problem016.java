package nl.ramblings.euler.set010;
import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number 
 * 2^1000?
 * 
 * @author Marco de Jong
 */
public class Problem016 {

    public static void main(String[] args) {
        Problem016 problem = new Problem016();
        long start = System.nanoTime();
        long result = problem.powerDigitSum(1000);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 16 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
    }
    
    public int powerDigitSum(int exponent) {
        int result = 0;

        for (char i : new BigInteger("2").pow(exponent).toString().toCharArray())
            result += i - 48;

        return result;
    }
}
