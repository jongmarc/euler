package nl.ramblings.euler.set010;
import static org.junit.Assert.*;

import org.junit.Test;


public class Problem015Test {

    @Test
    public void test() {
        assertEquals(2, new Problem015().countLatticePaths(1));
        assertEquals(6, new Problem015().countLatticePaths(2));
        assertEquals(20, new Problem015().countLatticePaths(3));
        assertEquals(70, new Problem015().countLatticePaths(4));

    }
}
