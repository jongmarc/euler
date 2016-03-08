package nl.ramblings.euler.set000;
/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 
 * @author Marco de Jong
 */
public class Problem007 {

    public static void main(String[] args) {
        Problem007 problem = new Problem007();
        long start = System.nanoTime();
        int result = problem.findNthPrime(10001);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 7 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientFindNthPrime(10001);
        stop = System.nanoTime();
        System.out.println("\nProblem 7 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
        start = System.nanoTime();
        result = problem.improvedEfficientFindNthPrime(10001);
        stop = System.nanoTime();
        System.out.println("\nProblem 7 with efficient algorithm but with my improved isPrime() method\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }
    
    public int findNthPrime(int N) {
        if (N < 1)
            return -1;
        
        int numberOfPrimesFound = 0;
        int counter = 2;
        do {
            if ( isPrime(counter) )
                numberOfPrimesFound++;
            
          counter++;  
        } while (numberOfPrimesFound < N);
        return counter - 1;
    }
    
    protected boolean isPrime(int n) {
        if (n < 2)
            return false;
        
        if (n == 2 || n == 3)
            return true;
        
        if ( n % 2 == 0 || n % 3 == 0 )
            return false;
        
        int maxDivisior = (int)Math.sqrt(n);
        int divisor = 5;

        while (divisor <= maxDivisior) {
            if (n % divisor == 0 || n % (divisor + 2) == 0)
                return false;
            divisor += 6;
        }
        
        return true;
    }
    
    public int efficientFindNthPrime(int limit) {
        int count = 1; //we  know that 2 is prime
        int candidate = 1;
        
        do {
            candidate = candidate + 2;
            if ( efficientIsPrime(candidate) ) 
                count = count + 1;
        } while (count != limit);

        return candidate;
    }
    
    public int improvedEfficientFindNthPrime(int limit) {
        int count = 1; //we  know that 2 is prime
        int candidate = 1;
        
        do {
            candidate = candidate + 2;
            if ( isPrime(candidate) ) 
                count = count + 1;
        } while (count != limit);

        return candidate;
    }
    
    protected boolean efficientIsPrime(int n) {
        if (n == 1)
            return false;
        else if (n < 4)
            return true;
        else if (n % 2 == 0)
            return false;
        else if (n < 9)
            return true;
        else if (n % 3 == 0)
            return false;
        else {
            int r = (int)Math.floor( Math.sqrt( n ) ); // n rounded to the greatest integer r so that r*r<=n f=5
            int f = 5;
            while (f <= r ) {
                if (n % f == 0)
                    return false;
                if (n % (f + 2) == 0)
                    return false;
                f = f + 6;
            }
        }       
        return true;
    }
}
