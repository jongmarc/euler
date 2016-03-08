package nl.ramblings.euler.set010;
/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Marco de Jong
 */
public class Problem010 {

    public static void main(String[] args) {
        Problem010 problem = new Problem010();
        long start = System.nanoTime();
        long result = problem.summationOfPrimes(1999999);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 10 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientSummationOfPrimes(1999999);
        stop = System.nanoTime();
        System.out.println("\nProblem 10 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }
    
    /**
     * Find the sum of all primes until (and including) the limit
     * @param limit of the primes to include in the sum
     * @return the sum of all primes below and including the limit
     */
    public long summationOfPrimes(int limit) {
        if (limit < 2)
            return 0;
        else if (limit == 2)
            return 2;
        long candidate = 3;
        long sumOfPrimes = 2;
        
        while (candidate <= limit) {
            if ( isPrime((int)candidate) ) 
                sumOfPrimes += candidate;
            candidate += 2;
        } 

        return sumOfPrimes;
    }

    protected boolean isPrime(long n) {
        if (n < 2)
            return false;
        
        if (n == 2 || n == 3)
            return true;
        
        if ( n % 2 == 0 || n % 3 == 0 )
            return false;
        
        long maxDivisior = (int)Math.sqrt(n);
        long divisor = 5;

        while (divisor <= maxDivisior) {
            if (n % divisor == 0 || n % (divisor + 2) == 0)
                return false;
            divisor += 6;
        }
        
        return true;
    }
    
    /**
     * The basic idea behind this ancient method is that instead of looking for divisors d of n, we 
     * mark multiples of d as composites. Since every composite has a prime divisor, the marking of 
     * multpiples need only be done for primes. The classical algorithm is:
     * 
     * 1. Make a list of all numbers from 2 to N.
     * 2. Find the next number p not yet crossed out. This is a prime. 
     *    If it is greater than root of N, go to 5.
     * 3. Cross out all multiples of p which are not yet crossed out.
     * 4. Go to 2.
     * 5. The numbers not crossed out are the primes not exceeding N.
     * 
     * You only need to start crossing out multiples at p2, because any smaller multiple of p has a 
     * prime divisor less than p and has already been crossed out as a multiple ￼of that. This is also
     * the reason why we can stop after we’ve reached root of n
     * 
     * @param limit of the primes to include in the sum
     * @return the sum of all primes below and including the limit
     */
    public long efficientSummationOfPrimes(int limit) {
        if (limit < 2)
            return 0;
        else if (limit == 2)
            return 2;

        int sievebound = (limit - 1) / 2;                   // last index of sieve
        boolean[] sieve = new boolean[sievebound + 1];
        int crosslimit = (int)Math.round(( Math.floor( Math.sqrt( limit ) ) - 1) / 2);

        for (int i = 1; i <= crosslimit; i++)
            if (!sieve[i])                                // 2*i+1 is prime, mark multiples
                for (int j = 2 * i * (i + 1); j <= sievebound; j += 2 * i + 1)
                    sieve[j] = true;
        long sum = 2;                                     // 2 is prime
        for (int i = 1; i <= sievebound; i++)
            if (!sieve[i])
                sum += (2 * i + 1);
        return sum;
    }

 
}
