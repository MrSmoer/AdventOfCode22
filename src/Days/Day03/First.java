package Days.Day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        String[] zeilen = readLines("src/Days/Day03/input.txt");
        int score = 0;
        List<Rucksack> saecke = new ArrayList<>();
        for (String zeile : zeilen){
            if (zeile.length()>1)
            saecke.add(new Rucksack(zeile));
            else System.out.println("Bad line");

        }
        for (Rucksack sack : saecke){
            score+=convertItem(sack.getOverlappingItem());
        }
        System.out.println(score);
        // System.out.println((int)'a'+" "+(int)'z'+ " "+ (int)'A'+ " "+(int)'Z');
        // System.out.println(convertItem('z'));
        // System.out.println(convertItem('Z'));

    }

    public static int convertItem(char item){
        if((int)item>=(int)'A'&&(int)item<=(int)'Z'){
            //Uppercase
            return (int)item -(int)'A' + 27;
        } else {
            //Lowercase
            return (int)item-(int)'a'+ 1;
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