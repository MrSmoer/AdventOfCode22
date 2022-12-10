package Days.Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        //String[] zeilen = readLines("src/Days/Day4/input.txt");
        String[] zeilen = readLines("src/Days/Day4/testInput.txt");
        int score = 0;
        for (String zeile : zeilen){
            String[] ranges = zeile.split(",");
            Section first = convertRangeToSection(ranges[0]);
            Section second = convertRangeToSection(ranges[1]);
            if(first.fullyContains(second)||second.fullyContains(first))
                score++;
        }
        System.out.println(score);

    }

    public static Section convertRangeToSection(String range){
        String[] numbers = range.split("-");
        return new Section(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    }

    public static String[] readLines(String filename) {
        try (FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[1];
        }
    }
}