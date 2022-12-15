package Days.Day15;

import java.util.ArrayList;
import java.awt.Point;

public class Cave {
    ArrayList<ArrayList<Cell>> grid;
    Point cordsOfTopLeft;
    Point startingPosition;

    public Cave() {
        this.grid = new ArrayList<ArrayList<Cell>>();
    }

    public void setGrid(ArrayList<ArrayList<Cell>> grid, Point topLeft) {
        this.grid = grid;
        this.cordsOfTopLeft = topLeft;
    }



    public Point relative(Point start) {
        return new Point(start.x - this.cordsOfTopLeft.x, start.y - this.cordsOfTopLeft.y);
    }
    public void drawObject(Point absoulute, Cell cell) {
        Point relativePoint = relative(absoulute);
        this.grid.get(relativePoint.x).set(relativePoint.y, cell);
    }

    public void printGrid() {
        //System.out.println(cordsOfTopLeft);
        for (int y = 0; y < this.grid.get(0).size(); y++) {
            String outputLine = "";
            for (int x = 0; x < this.grid.size(); x++) {
                outputLine += this.grid.get(x).get(y).symbol;
            }
            System.out.println(outputLine);
        }
    }


    

    
}
