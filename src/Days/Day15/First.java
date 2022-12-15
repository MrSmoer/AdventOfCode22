package Days.Day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.Position;

import java.awt.Point;

public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            // positionCount = solve(provideBufferedReader("src/Days/Day15/input.txt"));
            positionCount = solve(provideBufferedReader("src/Days/Day15/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String readLine;
        ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();
        ArrayList<Beacon> beacons = new ArrayList<Beacon>();
        Point startingPosition = new Point(0, 0);
        Point smallest = new Point(startingPosition);
        Point biggest = new Point(startingPosition);
        try {

            while ((readLine = bufferedReader.readLine()) != null) {

                String[] elements = readLine.split(" at ");
                ArrayList<Point> pair = new ArrayList<>();
                for (int i = 1; i < 3; i++) {
                    Point newPoint = convertPoint(elements[i].split(":")[0]);
                    if (newPoint.x > biggest.x) {
                        biggest.x = newPoint.x;
                    } else if (newPoint.x < smallest.x) {
                        smallest.x = newPoint.x;
                    }
                    if (newPoint.y > biggest.y) {
                        biggest.y = newPoint.y;
                    } else if (newPoint.y < smallest.y) {
                        smallest.y = newPoint.y;
                    }
                    pair.add(newPoint);
                }
                boolean isInList = false;
                Beacon beacon = new Beacon(pair.get(1));
                for(Beacon beacon2 : beacons){
                    if(beacon.getPosition().x==beacon2.getPosition().x&&beacon.getPosition().y==beacon2.getPosition().y){
                        beacon=beacon2;
                        isInList=true;
                        continue;
                    }
                }
                if(!isInList){
                    beacons.add(beacon);
                }
                Sensor sensor = new Sensor(pair.get(0), beacon);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int xColumns = smallest.x; xColumns < (biggest.x); xColumns++) {
            ArrayList<Cell> yRow = new ArrayList<Cell>();
            for (int yRows = smallest.y; yRows < (biggest.y - smallest.y); yRows++) {
                char cellchar = '.';
                yRow.add(new Cell(new Point(xColumns, yRows), cellchar));
            }
            grid.add(yRow);
        }
        Cave cave = new Cave();
        cave.setGrid(grid, smallest);
        int result = 0;
        return result - 1;

    }

    public static Point convertPoint(String input) {
        String[] cords = input.split(", ");
        int x = Integer.parseInt(cords[0].substring(2));
        int y = Integer.parseInt(cords[1].substring(2));
        return new Point(x, y);
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}