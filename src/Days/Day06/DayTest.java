package Days.Day06;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.Test;

public class DayTest {
    @Test
    public void testSolveFirst() {
        assertEquals(0, First.solve(new BufferedReader(new StringReader("test"))));
        assertEquals(0, First.solve(new BufferedReader(new StringReader("teste"))));
        assertEquals(5, First.solve(new BufferedReader(new StringReader("testi"))));
        assertEquals(5, First.solve(new BufferedReader(new StringReader("bvwbjplbgvbhsrlpgdmjqwftvncz"))));
        assertEquals(6, First.solve(new BufferedReader(new StringReader("nppdvjthqldpwncqszvftbrmjlhg"))));
        assertEquals(10, First.solve(new BufferedReader(new StringReader("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))));
        assertEquals(11, First.solve(new BufferedReader(new StringReader("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))));
    }

    @Test
    public void testSolveSecond() {
        assertEquals(0, Second.solve(new BufferedReader(new StringReader("test"))));
        assertEquals(0, Second.solve(new BufferedReader(new StringReader("teste"))));
        assertEquals(4, Second.solve(new BufferedReader(new StringReader("qwertzuiopasdfghjklyxcvbnm"))));
        assertEquals(19, Second.solve(new BufferedReader(new StringReader("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))));
        assertEquals(23, Second.solve(new BufferedReader(new StringReader("bvwbjplbgvbhsrlpgdmjqwftvncz"))));
        assertEquals(23, Second.solve(new BufferedReader(new StringReader("nppdvjthqldpwncqszvftbrmjlhg"))));
        assertEquals(29, Second.solve(new BufferedReader(new StringReader("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))));
        assertEquals(26, Second.solve(new BufferedReader(new StringReader("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))));
    }
}
