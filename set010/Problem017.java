package nl.ramblings.euler.set010;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total. If all the numbers from 1 to 1000 (one thousand) 
 * inclusive were written out in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
 * and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in 
 * compliance with British usage.
 * 
 * @author Marco de Jong
 */
public class Problem017 {
    public static void main(String[] args) {
        Problem017 problem = new Problem017();
        long start = System.nanoTime();
        int result = 0;
        for (int i = 1; i <= 1000; i++)
            result += problem.numberLetterCount(i);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 17 with my algorithm\n" + result + " in " + duration + " nanoseconds.");
    }
    
    public int numberLetterCount(int number) {
        int result = 0;
        String numberInLetters = numberInLetters(number).toUpperCase();
        for (char letter: numberInLetters.toCharArray())
            if (letter >= 65 && letter <=90 )
                result++;
        
        return result;
    }

    public String numberInLetters(int number) {
        StringBuilder result = new StringBuilder();

        // minus = 5 letters
        if (number < 0) {
            number = Math.abs(number);
            result.append("minus ");        
        }
        // numbers 1.000, 1000.000, 1000.000.000 scale the number 
        int[] scalingNumbers = new int[] { 1, 1000, 1000000, 1000000000 };
        String[] scalingLetters = new String[] { "", "thousend ", "million ", "billion " };  // trillion, quadrillion, quintillion, sextillion, septillion
        for (int i = scalingNumbers.length - 1; i > 0; i--) {
            if ((number % scalingNumbers[i]) / scalingNumbers[i - 1] > 0)
                result.append(numberInLettersBelowThousend((number % scalingNumbers[i]) / scalingNumbers[i-1]) + " " + scalingLetters[i - 1]);    
        }
        
        return result.toString().trim();
    }
    
    private String numberInLettersBelowThousend(int number) {
        StringBuilder result = new StringBuilder();

        // numbers 0 - 19 are somewhat different that the rest of the number system
        String[] letterCountFirst20Numbers = new String[] { "zero", "one", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "eleven", "twelf", "thirteen", "fourteen", "fifteen", "sixteen", 
                "seventeen", "eightteen", "nineteen" };
        // numbers 0, 10, 20, 30 ... 90
        String[] letterCountDozens = new String[] { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    
        if (number % 1000 > 99) {
            result.append(letterCountFirst20Numbers[(number % 1000) / 100] + " hundred ");
            if (number % 100 != 0)
                result.append("and ");
        }

        if (number % 100 > 19) {
            result.append(letterCountDozens[(number % 100) / 10]);
            if (number % 10 > 0) {
                result.append("-");
                result.append(letterCountFirst20Numbers[(number % 10)]);
            }
        } else {
            if (number % 20 > 0) {
                result.append(letterCountFirst20Numbers[(number % 20)]);
            }
        }
        
        return result.toString().trim();
    }        
}
