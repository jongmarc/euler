package nl.ramblings.euler.set000;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem004Test {

    @Test
    public void testIsPalindrome() {
        assertEquals(true, new Problem004().isPalindrome(9));
        assertEquals(false, new Problem004().isPalindrome(10));        
        assertEquals(true, new Problem004().isPalindrome(11));
        assertEquals(false, new Problem004().isPalindrome(12));
        assertEquals(false, new Problem004().isPalindrome(21));
        assertEquals(true, new Problem004().isPalindrome(22));
        assertEquals(false, new Problem004().isPalindrome(23));
    }
    
    @Test
    public void testLargestPalindrome() {
        assertEquals(9009, new Problem004().largest(2));
        assertEquals(906609, new Problem004().largest(3));
    }
}
