package Days.Day14;

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
            // positionCount = solve(provideBufferedReader("src/Days/Day14/input.txt"));
            positionCount = solve(provideBufferedReader("src/Days/Day14/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String readLine;
        ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();
        ArrayList<Line> lines = new ArrayList<Line>();
        Point startingPosition = new Point(500, 0);
        Point smallest = new Point(startingPosition);
        Point biggest = new Point(startingPosition);
        try {

            while ((readLine = bufferedReader.readLine()) != null) {
                Line rockLine = new Line();
                String[] elements = readLine.split(" ");
                for (int i = 0; i < elements.length; i++) {
                    if (i % 2 == 0) {
                        Point cornerPoint = convertPoint(elements[i]);
                        if (cornerPoint.x > biggest.x) {
                            biggest.x = cornerPoint.x;
                        } else if (cornerPoint.x < smallest.x) {
                            smallest.x = cornerPoint.x;
                        }
                        if (cornerPoint.y > biggest.y) {
                            biggest.y = cornerPoint.y;
                        } else if (cornerPoint.y < smallest.y) {
                            smallest.y = cornerPoint.y;
                        }
                        rockLine.addPoint(cornerPoint);
                    }
                }
                lines.add(rockLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        smallest = new Point(smallest.x - 1, smallest.y);
        biggest = new Point(biggest.x + 1, biggest.y + 1);

        for (int xColumns = smallest.x; xColumns < (biggest.x); xColumns++) {
            ArrayList<Cell> yRow = new ArrayList<Cell>();
            for (int yRows = smallest.y; yRows < (biggest.y - smallest.y); yRows++) {
                yRow.add(new Cell(new Point(xColumns,yRows)));
            }
            grid.add(yRow);
        }
        Cave cave = new Cave();
        cave.setGrid(grid,smallest);

        for(Line line : lines){
            cave.drawLine(line);
        }
        while(!cave.hasSandInAbyss()){
            cave.dropSand(startingPosition);
        }

        int result = 0;
        return result;

    }

    public static Point convertPoint(String input) {
        String[] cords = input.split(",");
        int x = Integer.parseInt(cords[0]);
        int y = Integer.parseInt(cords[1]);
        return new Point(x, y);
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}