package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem014Test {

    @Test
    public void test() {
        assertEquals(1, new Problem014().lengthCollatzSequence(1));
        assertEquals(2, new Problem014().lengthCollatzSequence(2));
        assertEquals(10, new Problem014().lengthCollatzSequence(13));
        assertEquals(248, new Problem014().lengthCollatzSequence(113383));

    }

}
