package Days.Day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import java.awt.Point;

public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day13/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day13/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String line;
        try {

            while ((line = bufferedReader.readLine()) != null) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}