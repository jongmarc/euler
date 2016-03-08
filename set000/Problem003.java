package nl.ramblings.euler.set000;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Marco de Jong
 */
public class Problem003 {

    public static void main(String[] args) {
        Problem003 problem = new Problem003();
        long start = System.nanoTime();
        BigInteger result = problem.largestPrimeFactor(new BigInteger("600851475143"));
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 3 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientLargestPrimeFactor(new BigInteger("600851475143"));
        stop = System.nanoTime();
        System.out.println("\nProblem 3 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }
    
    public int largestPrimeFactor(int n) {
        List<Integer> factors = primeFactors(n);

        if (factors.size() == 0)
            return 0;

        Collections.sort(factors);
        return factors.get(factors.size() - 1);
    }
    
    public BigInteger largestPrimeFactor(BigInteger n) {
        List<BigInteger> factors = primeFactors(n);

        if (factors.size() == 0)
            return new BigInteger("0");

        Collections.sort(factors);
        return (BigInteger)factors.get(factors.size() - 1);
    }
    
    public BigInteger efficientLargestPrimeFactor(BigInteger n) {
        BigInteger b0= new BigInteger("0");
        BigInteger b1= new BigInteger("1");
        BigInteger b2 = new BigInteger("2");
        BigInteger lastFactor;
        
        if (n.mod(b2).equals(b0)) {
            lastFactor = b2;
            n = n.divide(b2);
            while (n.mod(b2).equals(b0))
                n = n.divide(b2);
        } else
            lastFactor = b1;
        
        BigInteger factor = new BigInteger("3");
        BigInteger maxFactor = bigIntSqRootCeil(n);
        while (n.compareTo(b1) > 0 && factor.compareTo(maxFactor) <= 0){
            if (n.mod(factor).equals(b0)) {
                n = n.divide(factor);
                lastFactor = factor;
                while (n.mod(factor).equals(b0))
                    n = n.divide(factor);
                maxFactor = bigIntSqRootCeil(n);
            }
            factor = factor.add(b2);   
        }
        if (n.equals(b1))
            return lastFactor;
        else
            return n;
    }
  
    private BigInteger bigIntSqRootCeil(BigInteger x) throws IllegalArgumentException {
        if (x.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("Negative argument.");
        // square roots of 0 and 1 are trivial and
        // y == 0 will cause a divide-by-zero exception
        if (x == BigInteger.ZERO || x == BigInteger.ONE) {
            return x;
        } // end if
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger y;
        // starting with y = x / 2 avoids magnitude issues with x squared
        for (y = x.divide(two);
                y.compareTo(x.divide(y)) > 0;
                y = ((x.divide(y)).add(y)).divide(two));
        if (x.compareTo(y.multiply(y)) == 0)
            return y;
        else
            return y.add(BigInteger.ONE);
    } 
    
    
    public List<Integer> primeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        
        for (int i = 2; i <= n; i++)
            while (n % i == 0) {
                primeFactors.add( i );
                n = n / i;
            }

        return primeFactors;
    }
    
    
    public List<BigInteger> primeFactors(BigInteger n) {
        ArrayList<BigInteger> primeFactors = new ArrayList<BigInteger>();
        
        BigInteger i = new BigInteger("2");
        while (i.compareTo(n) <= 0) {
            while (n.remainder(i).compareTo(new BigInteger("0")) == 0) {
                primeFactors.add(i);
                n = n.divide(i);
            }
            i = i.add(new BigInteger("1"));
        }
        return primeFactors;
    }

}
