package Days.Day7;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class DayTest {
    public DayTest(){

        
    }

    @Test
    public void testSolveFirst() {
        try {
            BufferedReader inputReader = First.provideBufferedReader("src/Days/Day7/input.txt");
            BufferedReader testInputReader = First.provideBufferedReader("src/Days/Day7/testInput.txt");
            assertEquals(95437, First.solve(testInputReader));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testSolveSecond() {
        try {
            BufferedReader inputReader = Second.provideBufferedReader("src/Days/Day7/input.txt");
            BufferedReader testInputReader = Second.provideBufferedReader("src/Days/Day7/testInput.txt");
            assertEquals(24933642, Second.solve(testInputReader));
            assertEquals(24933642, Second.solve(testInputReader));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
