package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem017Test {

    @Test
    public void testNumberInLetters() {
        assertEquals("minus five", new Problem017().numberInLetters(-5));  
        assertEquals("one", new Problem017().numberInLetters(1));      
        assertEquals("two", new Problem017().numberInLetters(2));      
        assertEquals("three", new Problem017().numberInLetters(3));      
        assertEquals("twenty", new Problem017().numberInLetters(20));       
        assertEquals("twenty-one", new Problem017().numberInLetters(21));    
        assertEquals("thirty-three", new Problem017().numberInLetters(33));    
        assertEquals("ninety-nine", new Problem017().numberInLetters(99));    
        assertEquals("one hundred", new Problem017().numberInLetters(100));    
        assertEquals("one hundred and one", new Problem017().numberInLetters(101));    
        assertEquals("one hundred and fifteen", new Problem017().numberInLetters(115));    
        assertEquals("one hundred and forty-two", new Problem017().numberInLetters(142));    
        assertEquals("nine hundred and ninety-nine", new Problem017().numberInLetters(999));    
        assertEquals("one thousend", new Problem017().numberInLetters(1000));    
        assertEquals("one thousend one", new Problem017().numberInLetters(1001));    
        assertEquals("three thousend fifty-five", new Problem017().numberInLetters(3055));

        // No 'and' with numbers larger than 1000 (in this implementation)
        assertEquals("forty-four million nine hundred and sixty-one thousend eighty-seven", new Problem017().numberInLetters(44961087));    
    }
    
    @Test
    public void testNumberLetterCount() {
        assertEquals(9, new Problem017().numberLetterCount(-5));        // minus five = 9 letters
        assertEquals(3, new Problem017().numberLetterCount(1));         // one = 3 letters
        assertEquals(3, new Problem017().numberLetterCount(2));         // two = 3 letters
        assertEquals(5, new Problem017().numberLetterCount(3));         // three = 5 letters
        assertEquals(6, new Problem017().numberLetterCount(20));        // twenty = 6 letters
        assertEquals(9, new Problem017().numberLetterCount(21));        // twenty-one = 9 letters
        assertEquals(20, new Problem017().numberLetterCount(115));      // one hundred and fifteen = 20 letters
        assertEquals(23, new Problem017().numberLetterCount(555));      // five hundred and fifty-five = 23 letters
        assertEquals(23, new Problem017().numberLetterCount(342));      // three hundred and forty-two = 23 letters

    }

}
