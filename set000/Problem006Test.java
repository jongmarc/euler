package nl.ramblings.euler.set000;
import static org.junit.Assert.*;
import org.junit.Test;


public class Problem006Test {

    @Test
    public void test() {
        assertEquals(4, new Problem006().sumSquareDifference(2));
        assertEquals(22, new Problem006().sumSquareDifference(3));
        assertEquals(70, new Problem006().sumSquareDifference(4));
        assertEquals(2640, new Problem006().sumSquareDifference(10));
    }
}
