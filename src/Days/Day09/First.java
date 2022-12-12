package Days.Day09;

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
            positionCount = solve(provideBufferedReader("src/Days/Day09/input.txt"));
            //positionCount = solve(provideBufferedReader("src/Days/Day09/testInput.txt"));
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
                MoveCommand moveCommand = new MoveCommand(Integer.parseInt(line.substring(2, line.length())), line.charAt(0));
                commandList.add(moveCommand);
            }
            bufferedReader.close();

            Head head = new Head();
            Tail tail = new Tail(1, new Tail(0, null));

            List<Point> visitedPoints = new ArrayList<Point>();
            visitedPoints.add(new Point(0,0));


            for (MoveCommand moveCommand : commandList) {
                for (int currentSteps = 0; currentSteps < moveCommand.steps(); currentSteps++) {
                    Point oldHead= new Point(head);
                    head.moveOne(moveCommand.direction());
                    tail.knotAbove.setLocation(head);
                    tail.updateLocation(oldHead);
                    
                    boolean contains = false;
                    for(Point listPoint:visitedPoints){
                        if(isSame(listPoint,tail))
                            contains = true;
                    }

                    if(!contains){
                        visitedPoints.add(new Point(tail));
                    }
                    
                }
                
            }
            size=visitedPoints.size();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size; // 3031 too low

    }

    private static boolean isSame(Point listPoint, Tail tail) {
        if(listPoint.x==tail.x&&listPoint.y==tail.y)
            return true;
        return false;
    }

    public void generateMap(){
        
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}