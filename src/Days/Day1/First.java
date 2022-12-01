package Days.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        String[] zeilen = readLines("src/Days/Day1/input.txt");

        Elf aktuellerElf = new Elf();
        List<Elf> elfen = new ArrayList<>();
        for (int zeile = 0; zeile < zeilen.length; zeile++) {
            if (!zeilen[zeile].equals("")) {
                aktuellerElf.addItem(Integer.parseInt(zeilen[zeile]));
            } else {
                System.out.println("Letzter Elf: " + aktuellerElf.getCalories());
                elfen.add(aktuellerElf);
                aktuellerElf = new Elf();
            }
        }

        Elf biggestElf = new Elf();
        for (Elf elf : elfen) {
            if (biggestElf.getCalories() < elf.getCalories())
                biggestElf = elf;
        }
        System.out.println("BiggestElf: " + biggestElf.getCalories());

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
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new String[1];
        }
    }
}