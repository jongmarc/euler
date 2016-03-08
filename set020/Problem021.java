package nl.ramblings.euler.set020;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called 
 * amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) 
 * = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author Marco de Jong
 */
public class Problem021 {

    public static void main(String[] args) {
        Problem021 problem = new Problem021();
        long start = System.nanoTime();
        int result = problem.amicableNumbers(10000);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 21 with my algorithm\n" +  result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientAmicableNumbers(10000);
        stop = System.nanoTime();
        System.out.println("\nProblem 21 with my better algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }

    protected int amicableNumbers(int maxRange) {
        HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
        
        // precalculate all the divisor Sums
        for (int i = 1; i < maxRange; i++) {
            int sumOfThisNumber = 0;
            for (Integer divisor:  properDivisor(i))
                sumOfThisNumber += divisor;
            store.put(i, sumOfThisNumber);
        }

        // search for the amicable numbers
        int result = 0;
        for (int i = 1; i < maxRange; i++)
            if ( store.containsKey(i) 
                    && store.containsKey(store.get(i))
                    && store.get(i) != i
                    && store.get(store.get(i)) == i)
                result += i;
        return result;
    }
    
    protected ArrayList<Integer> properDivisor(int number) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (number < 1)
            number = Math.abs(number);
        list.add(1);
        for (int i = 2; i <= Math.sqrt(number); i++ ) {
            if (number % i == 0) {
                list.add(i);
                if (number / i != i)
                    list.add(number / i);
            }
        }
        return list;
    }
    
    public int efficientAmicableNumbers(int maxRange) {
        int sum = 0;
        for (int a = 2; a < maxRange; a++) {
            int b = SumOfProperDivisors(a) - a;

            if (b > a)
                if ( SumOfProperDivisors(b) - b == a)
                    sum += a + b;
        }
        return sum;
    }
    
    protected int SumOfProperDivisors(int n) {
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
