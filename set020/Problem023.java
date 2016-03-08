package nl.ramblings.euler.set020;
import java.util.ArrayList;


/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For 
 * example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a 
 * perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant 
 * if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as 
 * the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater 
 * than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced 
 * any further by analysis even though it is known that the greatest number that cannot be expressed as the 
 * sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * @author Marco de Jong
 */
public class Problem023 {

    public static void main(String[] args) {
       Problem023 problem = new Problem023();
       long start = System.nanoTime();
       int result = problem.nonAbundantSum();
       long stop = System.nanoTime();
       long duration = stop - start;
       System.out.println("Problem 23 with my algorithm\n" +  result + " in " + duration + " nanoseconds.");
    }
    
    public int nonAbundantSum() {
        // Precalculate the list with abundant numbers
        ArrayList<Integer> listOfAbundantNumbers = new ArrayList<Integer>();
        for (int i = 1; i < 28124; i++)
            if (SumOfProperDivisors(i) - i > i)
                listOfAbundantNumbers.add(i);
        
        // Mark off all numbers that can be made with 2 abundant numbers
        boolean[] invalidNumber = new boolean[28124];
        Integer[] arrayOfAbundantNumber = listOfAbundantNumbers.toArray(new Integer[0]);
        for(int i = 0; i < arrayOfAbundantNumber.length; i++) 
            for(int j = i; j < arrayOfAbundantNumber.length; j++) 
                if (arrayOfAbundantNumber[i] + arrayOfAbundantNumber[j] < 28124)
                    invalidNumber[arrayOfAbundantNumber[i] + arrayOfAbundantNumber[j]] = true;
        
        int result = 0;
        for(int i = 0; i < invalidNumber.length; i++)
            if (invalidNumber[i] == false)
                result += i;
        
        return result;
    }

    private int SumOfProperDivisors(int n) {
        int sum = 1;
        int p = 2;
        int j;
        while (p * p <= n && n > 1) {
            if (n % p == 0 ) {
                j = p * p;
                n /= p;
                while (n % p == 0) {
                    j *= p;
                    n /= p;
                }
                sum *= (j - 1);
                sum /= (p - 1);
            }
            if (p == 2)
                p = 3;
            else 
                p += 2;
        }    
        if (n > 1)
            sum *= (n + 1);
    
        return sum;
    }
}
