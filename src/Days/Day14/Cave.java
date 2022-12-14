package Days.Day14;

import java.util.ArrayList;
import java.awt.Point;

public class Cave {
    ArrayList<ArrayList<Cell>> grid;
    Point cordsOfTopLeft;

    public Cave() {
        this.grid = new ArrayList<ArrayList<Cell>>();
    }

    public void setGrid(ArrayList<ArrayList<Cell>> grid, Point topLeft) {
        this.grid = grid;
        this.cordsOfTopLeft = topLeft;
    }

    public void drawLine(Line line) {
        Point starPoint = null;
        for (Point p : line.points) {
            if (starPoint != null) {
                this.drawP2P(starPoint, p);
            }
            starPoint = p;
        }
    }

    public void drawP2P(Point start, Point end) {
        Point absStart = new Point(start.x - this.cordsOfTopLeft.x, start.y - this.cordsOfTopLeft.y);
        Point absEnd = new Point(end.x - this.cordsOfTopLeft.x, end.y - this.cordsOfTopLeft.y);
        int fieldsToDraw = (absStart.x - absEnd.x) + (absStart.y - absEnd.y);
        if (fieldsToDraw < 0)
            fieldsToDraw = -1 * fieldsToDraw;
        Point brush = absStart;
        drawRock(brush);
        printGrid();
        Point oneStep;
        if (absStart.x - absEnd.x == 0)
            oneStep = new Point(0, absEnd.y - absStart.y / fieldsToDraw);
        else
            oneStep = new Point(absEnd.x - absStart.x / fieldsToDraw, 0);
        for (int drawnFields = 0; drawnFields < fieldsToDraw; drawnFields++) {
            brush.setLocation(brush.x + oneStep.x, brush.y + oneStep.y);
            drawRock(brush);
            printGrid();
        }
    }

    public void drawRock(Point brush) {
        this.grid.get(brush.x).set(brush.y, new Rock());
    }

    public void printGrid() {
        for (int y = 0; y < this.grid.get(0).size(); y++) {
            String outputLine = "";
            for (int x = 0; x < this.grid.size(); x++) {
                outputLine += this.grid.get(x).get(y);
            }
            System.out.println(outputLine);
        }
    }

    public boolean hasSandInAbyss() {
        return false;
    }

    public void dropSand(Point startingPosition) {
    }
}
