package Days.Day6;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.Test;

public class FirstTest {
    @Test
    public void testSolve() {
        assertEquals(0, First.solve(new BufferedReader(new StringReader("test"))));
        assertEquals(0, First.solve(new BufferedReader(new StringReader("teste"))));
        assertEquals(5, First.solve(new BufferedReader(new StringReader("testi"))));
        assertEquals(5, First.solve(new BufferedReader(new StringReader("bvwbjplbgvbhsrlpgdmjqwftvncz"))));
        assertEquals(6, First.solve(new BufferedReader(new StringReader("nppdvjthqldpwncqszvftbrmjlhg"))));
        assertEquals(10, First.solve(new BufferedReader(new StringReader("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))));
        assertEquals(11, First.solve(new BufferedReader(new StringReader("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))));
    }
}
