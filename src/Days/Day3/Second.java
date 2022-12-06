package Days.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        String[] zeilen = readLines("src/Days/Day3/input.txt");
        int score = 0;
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < zeilen.length; System.out.println("New group")) {
            Group newGroup = new Group();
            if (i + 3 > zeilen.length){
                i++;
                continue;
            }
            for (int c = 0; c < 3; c++) {
                // if (i+2>zeilen.length)
                // continue;
                String aktuelleZeile = zeilen[i];
                if (aktuelleZeile.length() > 1) {
                    newGroup.addRucksack(new Rucksack(aktuelleZeile));
                } else
                    System.out.println("Bad line");
                i++;
            }

            System.out.println();
            groups.add(newGroup);

        }
        for (Group group : groups) {
            char badge = group.getBadge();
            System.out.println(convertItem(badge) + " " + badge);
            score += convertItem(badge);
        }
        // 1828 to low
        System.out.println(score);
        // System.out.println((int)'a'+" "+(int)'z'+ " "+ (int)'A'+ " "+(int)'Z');
        // System.out.println(convertItem('z'));
        // System.out.println(convertItem('Z'));

    }

    public static int convertItem(char item) {
        if ((int) item >= (int) 'A' && (int) item <= (int) 'Z') {
            // Uppercase
            return (int) item - (int) 'A' + 27;
        } else {
            // Lowercase
            return (int) item - (int) 'a' + 1;
        }
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