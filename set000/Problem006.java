package nl.ramblings.euler.set000;
/**
 * Problem 6 - Sum square difference
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square
 * of the sum is 3025 ??? 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and 
 * the square of the sum.
 * 
 * @author Marco de Jong
 *
 */
public class Problem006 {

    public int sumSquareDifference(int maxNaturalNumber) {
        if (maxNaturalNumber == 1)
            return 0;
        
        return sumSquareDifference(maxNaturalNumber - 1) + 2 * maxNaturalNumber * addedSumsTill(maxNaturalNumber - 1);
    }
    
    private int addedSumsTill(int step) {

        int result = 0;
        for (int i = 1; i <= step; i++)
            result += i;
        return result;  
    }
    
    public static void main(String[] args) {
        Problem006 problem = new Problem006();
        long start = System.nanoTime();
        int result = problem.sumSquareDifference(100);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 6 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientSumSquareDifference(100);
        stop = System.nanoTime();
        System.out.println("\nProblem 6 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }
    
    private int efficientSumSquareDifference(int maxNaturalNumber) {
        int sum = maxNaturalNumber * (maxNaturalNumber + 1) / 2;
        int sumSquared = (2 * maxNaturalNumber + 1) * (maxNaturalNumber + 1) * maxNaturalNumber / 6;
        return sum * sum - sumSquared;
    }
    


}

/**
 * Reasoning ...
 *
 *         Difference 2            Difference 3                    Difference 4
 *  
 * 1*2     (1+2) * (1+2) = 9       (1+2+3) * (1+2+3) = 36          (1+2+3+4) * (1+2+3+4) = 100
 *                         -                            -                                    -
 * 1*1     1*1 + 2*2     = 5       1*1 + 2*2 + 3*3   = 14          1*1 + 2*2 + 3*3 + 4*4  = 30      
 *                         =                            =                                    =
 * 1                       4       4 + 2 * 3 * (1+2) = 22          22 + 2 * 4 * (1+2+3)   = 70
 * 
 * step = 100
 * ==
 * difference(step - 1) + 2 * step * addedSumsTill(step - 1)
 * ==>
 * difference(99) + 2 * 100 * addedSumsTill(99)
 * ==>
 * difference(98) + 2 * 100 * addedSumsTill(98)
 * ==> 
 * ...
 * ==>
 * difference(2) + 2 * 3 * addedSumsTill(2) ==> 4 + 2 * 3 * 3 = 22
 * ==>
 * difference(1) + 2 * 2 * addedSumsTill(1) ==> 0 + 2 * 2 * 1 = 4 (difference 1 has to return 0!)
 * 
 **/