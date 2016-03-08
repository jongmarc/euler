package nl.ramblings.euler.set010;
/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not 
 * been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Marco de Jong
 */
public class Problem014 {

    public static void main(String[] args) {
        Problem014 problem = new Problem014();
        long start = System.nanoTime();
        int result = problem.findLargestCollatzSequence(1000000);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 14 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
    }
    
    public int findLargestCollatzSequence(int maxRange) {
        int longest = 0;
        int longestNumber = 0;
        for (int i = 1; i < maxRange; i++) {
            int temp = lengthCollatzSequence(i);
            if (temp > longest) {
                longest = temp;
                longestNumber = i;
            }
        }
        return longestNumber;
    }
   
    public int lengthCollatzSequence(int startingNumber) {
        if (startingNumber < 2)
            return 1;

        long number = startingNumber;
        int length = 1;
        do {
            if (number % 2 == 0)
                number = number / 2;
            else
                number = number * 3 + 1;
            length++;
        } while (number != 1);
        
        return length;
    }
}
