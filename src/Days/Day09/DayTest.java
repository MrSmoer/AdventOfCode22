package Days.Day09;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;

public class DayTest {
    public DayTest(){

        
    }

    @Test
    public void testSolveFirst() throws IOException {
        
    }

    @Test
    public void testSolveSecond() {
        try {
            //BufferedReader inputReader = Second.provideBufferedReader("src/Days/Day8/input.txt");
            BufferedReader testInputReader = Second.provideBufferedReader("src/Days/Day8/testInput.txt");
            assertEquals(24933642, Second.solve(testInputReader));
            assertEquals(24933642, Second.solve(testInputReader));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
