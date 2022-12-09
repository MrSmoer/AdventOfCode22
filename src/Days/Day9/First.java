package Days.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.Point;

public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            // positionCount = solve(provideBufferedReader("src/Days/Day9/input.txt"));
            positionCount = solve(provideBufferedReader("src/Days/Day9/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        int size = 0;
        String line = null;
        List<MoveCommand> commandList = new ArrayList<MoveCommand>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                MoveCommand moveCommand = new MoveCommand(Integer.parseInt(line.charAt(2) + ""), line.charAt(0));
                commandList.add(moveCommand);
            }
            bufferedReader.close();

            Head head = new Head();
            Point tail = new Head();
            Point highest = new Point(0, 0);
            Point lowest = new Point(0, 0);

            for (MoveCommand moveCommand : commandList) {
                for (int currentSteps = 0; currentSteps < moveCommand.steps(); currentSteps++) {
                    head.moveOne(moveCommand.direction());
                    if (head.x > highest.x)
                        highest.setLocation(head.x, highest.y);
                    if (head.y > highest.y)
                        highest.setLocation(highest.x, head.y);
                    if (head.x < lowest.x)
                        lowest.setLocation(head.x, lowest.y);
                    if (head.y < lowest.y)
                        lowest.setLocation(lowest.x, head.y);
                }
                System.out.println();
            }
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