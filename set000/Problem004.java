package nl.ramblings.euler.set000;
/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of 
 * two 2-digit numbers is 9009 = 91 ?????? 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Marco de Jong
 */
public class Problem004 {

    public int efficientLargest(int numberOfDigits) {
        int largestPalindrome = 0;
        int a = 999;
        int b, db;
        while (a >= 100) {
            if (a % 11 == 0) {
                b = 999;
                db = 1; 
            } else {
                b = 990; //The largest number less than or equal 999
                db = 11; //and divisible by 11
            }
            while (b >= a) {
                if (a * b <= largestPalindrome)
                    break;

                    if (efficientIsPalindrome(a * b))
                        largestPalindrome = a * b;
                    b = b-db;
            }
            a = a - 1;
        }
        return largestPalindrome;
    }
    
    private int efficientReverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = 10 * reversed + n % 10;
            n = n / 10;
        }
        return reversed;
    }
    
    private boolean efficientIsPalindrome(int n) {
        return n == efficientReverse(n);
    }
    
    public int improvedEfficientLargest(int numberOfDigits) {
        int largestPalindrome = 0;
        int a = 999;
        int b, db;
        while (a >= 100) {
            if (a % 11 == 0) {
                b = 999;
                db = 1; 
            } else {
                b = 990; //The largest number less than or equal 999
                db = 11; //and divisible by 11
            }
            while (b >= a) {
                if (a * b <= largestPalindrome)
                    break;

                    if (isPalindrome(a * b))
                        largestPalindrome = a * b;
                    b = b-db;
            }
            a = a - 1;
        }
        return largestPalindrome;
    }
    
    public int largest(int numberOfDigits) {
        int first = (int)Math.pow(10, numberOfDigits) - 1;
        int second = first;
        int highestFirst = 1;
        int highestSecond = -1;
        int lowerbound = (int)Math.pow(10, numberOfDigits - 1) - 1;

        do {
            if ( isPalindrome(first * second) && first * second > highestFirst * highestSecond ) {
                highestFirst = first;
                highestSecond = second;
            }

            first--;
            if ( first <= lowerbound) {
                first = second;
                second--;
            }
        } while (second > lowerbound);

        return highestFirst * highestSecond;
    }
    
    public boolean isPalindrome(int number) {
        if (number < 0) 
            return false;

        if (number < 10) 
            return true;

        String numberAsString = "" + number;
        int halfOfLength = numberAsString.length() / 2;
        return numberAsString.substring(0, halfOfLength).equals(new StringBuilder(numberAsString).reverse().substring(0, halfOfLength));
    }
    
    public static void main(String[] args) {
        Problem004 problem = new Problem004();
        long start = System.nanoTime();
        int result = problem.largest(3);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 4 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientLargest(3);
        stop = System.nanoTime();
        System.out.println("\nProblem 4 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
        start = System.nanoTime();
        result = problem.improvedEfficientLargest(3);
        stop = System.nanoTime();
        System.out.println("\nProblem 4 with efficient algorithm but with my improved isPrime() method\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }

}
