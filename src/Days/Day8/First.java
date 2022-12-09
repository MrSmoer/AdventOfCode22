package Days.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        int markerChars = 0;
        try {
            markerChars = solve(provideBufferedReader("src/Days/Day8/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(markerChars);
    }


    public static int solve(BufferedReader bufferedReader) {
        int size = 0;
        String line = null;
        List<List<Tree>> forest = new ArrayList<List<Tree>>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                List<Tree> rowOfTrees = new ArrayList<Tree>();
                for (Character c : line.toCharArray()) {
                    rowOfTrees.add(new Tree(Integer.parseInt(c + "")));
                }
                forest.add(rowOfTrees);
            }

            bufferedReader.close();

            Dunedain dunedain = new Dunedain(0, 0, Direction.DOWN, forest);
            List<Direction> directions = new ArrayList<>();
            directions.add(Direction.LEFT);
            directions.add(Direction.RIGHT);
            directions.add(Direction.DOWN);
            directions.add(Direction.UP);
            for (Direction direction : directions) {
                dunedain.setDirection(direction);
                dunedain.walkWholeDirection();
            }
            size = dunedain.foundTrees;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return size;

    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}