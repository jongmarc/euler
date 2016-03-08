package nl.ramblings.euler.set000;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author Marco de Jong
 */
public class Problem009 {

    public static void main(String[] args) {
        Problem009 problem = new Problem009();
        long start = System.nanoTime();
        int result = problem.specialPythagoreanTriplet(1000);
        long stop = System.nanoTime();
        long duration = stop - start;
        System.out.println("Problem 9 with my algorithm\n"+ result + " in " + duration + " nanoseconds.");
        start = System.nanoTime();
        result = problem.efficientSpecialPythagoreanTriplet(1000);
        stop = System.nanoTime();
        System.out.println("\nProblem 9 with efficient algorithm\n"+result + " in " + (stop - start) + " nanoseconds (" + String.format("%.2f", (float)(stop - start)/duration*100) + "% of original time).");
    }

    public int specialPythagoreanTriplet(int sumOfTriplet) {
        for (int i = 0; i < sumOfTriplet - 3; i++ )
            for (int j = i + 1; j < sumOfTriplet - 2; j++ )
                for (int k = j + 1; k < sumOfTriplet - 1; k++ )
                    if (i + j + k == sumOfTriplet)
                        if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2))
                            return i * j * k;
        return -1;
    }
    
    public int efficientSpecialPythagoreanTriplet(int sumOfTriplet) {
        int s2 = sumOfTriplet / 2;
        int mlimit = (int)Math.ceil(Math.sqrt(s2)) - 1;
        for (int m = 2; m <= mlimit; m++) {
            if (s2 % m == 0) {
                int sm = s2 / m;
                int k;
                while (sm % 2 == 0)     // reduce the search space by
                    sm = sm / 2;        // removing all factors 2
                if (m % 2 == 1)
                    k = m + 2;
                else
                    k = m + 1;
                
                while (k < 2 * m && k <= sm) {
                    if (sm % k == 0 && findGCD(k, m) == 1) {
                        int d = s2 / (k * m);
                        int n = k - m;
                        int a = d * (m * m - n * n);
                        int b = 2 * d * m * n;
                        int c = d * (m * m + n * n);
                        return a * b * c;
                    }
                    k = k + 2;
                }
            }
        }
        return -1;
    }
    
    private int findGCD(int number1, int number2) {
        if (number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }
}
