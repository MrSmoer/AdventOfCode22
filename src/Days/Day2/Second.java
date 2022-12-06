package Days.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        String[] zeilen = readLines("src/Days/Day2/input.txt");
        int score = 0;

        for (int zeile = 0; zeile < zeilen.length; zeile++) {
            if (!zeilen[zeile].contains(" ")) {
                System.out.println("Komische Zeile");
                System.out.println("score "+score);
                return;
            }
            String[] buchstaben = zeilen[zeile].split(" ");
            if (buchstaben[0].length() == 1 && buchstaben[1].length() == 1) {

                SecondMatch aktuellesMatch = new SecondMatch(buchstaben[0].charAt(0), buchstaben[1].charAt(0));
                score += aktuellesMatch.score;
                System.out.println("Match "+ aktuellesMatch.score);
            } else {
                System.out.println("Error Error");
                return;
            }
        }
        System.out.println("Score " + score);

        // Elf biggestElf = new Elf();
        // for (Elf elf : elfen) {
        // if (biggestElf.getCalories() < elf.getCalories())
        // biggestElf = elf;
        // }
        // System.out.println("BiggestElf: " + biggestElf.getCalories());

    }

    public static String[] readLines(String filename) {
        try (FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            lines.add("");
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[1];
        }
    }
}