package Days.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        int markerChars = 0;
        try {
            markerChars = solve(provideBufferedReader("src/Days/Day8/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(markerChars);
    }


    public static int solve(BufferedReader bufferedReader) {
        int size = 0;
        String line = null;
        

        return size;

    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}