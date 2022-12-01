import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First {

    public static void main(String[] args) {

        String[] zeilen = readLines("01/input.txt");
        int zeile = 0;
        int alterWert = 0;
        int großteElf = 0;
        while (zeile < zeilen.length) {
            if (zeilen[zeile].equals("")) {
                System.out.println("Leere Zeile");
                System.out.println(alterWert);
                if (alterWert>großteElf){
                    großteElf=alterWert;
                }
                alterWert=0;
            } else {
                int wertDerZeile = Integer.parseInt(zeilen[zeile]);
                alterWert = alterWert + wertDerZeile;
            }
            zeile = zeile + 1;
            ;

        }
        // letzter Elf
        if (alterWert>großteElf){
            großteElf=alterWert;
        }
        System.out.println(großteElf);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new String[1];
        }
    }
}