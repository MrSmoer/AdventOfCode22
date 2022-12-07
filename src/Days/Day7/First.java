package Days.Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        int markerChars = 0;
        try {
            markerChars = solve(readLines("src/Days/Day6/input.txt"));
        } catch (IOException e) {
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
        try {
            List<Command> commands = new ArrayList<Command>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.charAt(0)=='$')
                    commands.add(new Command(CommandType.LS));
                else {
                    commands.get(commands.size()-1).setOutput("line");
                }
            }
            bufferedReader.close();
            FileObject root = new FileObject();
            FileObject workingDirectory;

            workingDirectory = root;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }
}