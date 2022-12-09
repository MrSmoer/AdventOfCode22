package Days.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        int size = 0;
        try {
            size = solve(provideBufferedReader("src/Days/Day8/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(size);
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    public static int solve(BufferedReader bufferedReader) {

        int size = 0;
        String line;
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

            ScoreEvaluator scoreEvaluator = new ScoreEvaluator(0, 0, Direction.DOWN, forest);
            List<Direction> directions = new ArrayList<>();
            directions.add(Direction.LEFT);
            directions.add(Direction.RIGHT);
            directions.add(Direction.DOWN);
            directions.add(Direction.UP);
            for (List<Tree> rowList : forest) {
                for(Tree tree : rowList){
                    for (Direction direction : directions) {
                        scoreEvaluator.setDirection(direction);
                        scoreEvaluator.walkRow();
                    }
                }
            }

            size = scoreEvaluator.foundTrees;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return size;
    }
}