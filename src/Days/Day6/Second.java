package Days.Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Second{

    public static void main(String[] args) {

        int markerChars = 0;
        try {
            markerChars = solve(readLines("src/Days/Day6/input.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(markerChars);
    }

    public static BufferedReader readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;

    }

    public static int solve(BufferedReader bufferedReader) {

        char character = 0;
        int charnumber = 0;
        Subroutine subroutine = new Subroutine();
        try {
            while ((character = (char) bufferedReader.read()) != (char) -1) {
                charnumber++;
                subroutine.addChar(character,14);
                if (subroutine.isMarker())
                return charnumber;
            }
            System.out.println(charnumber);
            bufferedReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }
}