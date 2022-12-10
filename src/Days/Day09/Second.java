package Days.Day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.Point;

public class Second {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day9/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day9/largerTestInput.txt"));
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
                MoveCommand moveCommand = new MoveCommand(Integer.parseInt(line.substring(2, line.length())),
                        line.charAt(0));
                commandList.add(moveCommand);
            }
            bufferedReader.close();
            //map.printMap();

            Head head = new Head();
            Tail tail = new Tail(1, new Tail(0, null));
            Tail firstTail = tail;
            List<Tail> tails = new ArrayList<Tail>();
            tails.add(tail);
            Tail oldTail = tail;
            for (int knotCount = 1; knotCount < 9; knotCount++) {
                oldTail = tail;
                tail = new Tail(knotCount + 1, oldTail);
                tails.add(tail);
            }

            List<Point> visitedPoints = new ArrayList<Point>();
            visitedPoints.add(new Point(0, 0));

            for (MoveCommand moveCommand : commandList) {
                for (int currentSteps = 0; currentSteps < moveCommand.steps(); currentSteps++) {
                    Point oldHead = new Point(head);
                    head.moveOne(moveCommand.direction());

                    firstTail.knotAbove.setLocation(head);
                    tail.updateLocation(oldHead);

                    /*map.clearMap();
                    map.placeRelative(head, 'H');
                    for (Tail tailf : tails)
                        map.placeRelative(tailf, Character.forDigit(tailf.knotCount, 10));
                    map.printMap();*/

                    boolean contains = false;
                    for (Point listPoint : visitedPoints) {
                        if (isSame(listPoint, tail))
                            contains = true;
                    }

                    if (!contains) {
                        visitedPoints.add(new Point(tail));
                    }

                }
                //map.printMap();

            }
            size = visitedPoints.size();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size; // 3031 too low

    }

    private static boolean isSame(Point listPoint, Tail tail) {
        if (listPoint.x == tail.x && listPoint.y == tail.y)
            return true;
        return false;
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}