package Days.Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            //positionCount = solve(provideBufferedReader("src/Days/Day12/input.txt"));
            positionCount = solve(provideBufferedReader("src/Days/Day12/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String line;
        ArrayList<ArrayList<MapPoint>> map = new ArrayList<ArrayList<MapPoint>>();
        try {
            while((line=bufferedReader.readCh())!=null){


            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
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