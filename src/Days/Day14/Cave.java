package Days.Day14;

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

    public void drawLine(Line line) {
        Point starPoint = null;
        for (Point p : line.points) {
            if (starPoint != null) {
                this.drawP2P(starPoint, p);
            }
            starPoint = p;
        }
    }

    public Point absolute(Point start) {
        return new Point(start.x - this.cordsOfTopLeft.x, start.y - this.cordsOfTopLeft.y);
    }

    public void drawP2P(Point start, Point end) {
        Point absStart = absolute(start);
        Point absEnd = absolute(end);
        int fieldsToDraw = (absStart.x - absEnd.x) + (absStart.y - absEnd.y);
        if (fieldsToDraw < 0)
            fieldsToDraw = -1 * fieldsToDraw;
        Point brush = absStart;
        drawRock(brush);
        // printGrid();
        Point oneStep;
        if (absStart.x - absEnd.x == 0)
            oneStep = new Point(0, (absEnd.y - absStart.y) / fieldsToDraw);
        else
            oneStep = new Point((absEnd.x - absStart.x) / fieldsToDraw, 0);
        for (int drawnFields = 0; drawnFields < fieldsToDraw; drawnFields++) {
            brush.setLocation(brush.x + oneStep.x, brush.y + oneStep.y);
            // printGrid();
            drawRock(brush);
        }
    }

    public void drawRock(Point brush) {
        this.grid.get(brush.x).set(brush.y, new Rock());
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

    public boolean hasSandInAbyss() {
        for (int i = 0; i < this.grid.size(); i++) {
            Cell cell = this.grid.get(i).get(this.grid.get(0).size() - 1);
            if (cell instanceof Sand) {
                return true;
            }
        }
        // TODO test method
        return false;
    }

    public void dropSand(boolean withFloor) {
        Sand fallingSand = new Sand();
        fallingSand.position.setLocation(startingPosition.x, startingPosition.y);
        // this.grid.get(absolute(startingPosition).x).remove(absolute(startingPosition).y);
        // printGrid();
        //System.out.println("");
        Point absoluteSand = absolute(fallingSand.position);
        this.grid.get(absoluteSand.x).set(absoluteSand.y, fallingSand);
        //printGrid();
        while (!fallingSand.isSettled) {
            Point oldPosition = new Point(absoluteSand);
            this.grid.get(absoluteSand.x).set(absoluteSand.y, new Cell(oldPosition, '.'));
            if (fieldBelowIsFree(oldPosition)) {
                absoluteSand.y += 1;
            } else if (diagonalLeftIsFree(oldPosition)) {
                absoluteSand.x -= 1;
                absoluteSand.y += 1;
            } else if (diagonalRightIsFree(oldPosition)) {
                absoluteSand.x += 1;
                absoluteSand.y += 1;
            } else {
                fallingSand.setSettled();
            }
            fallingSand.setPosition(absoluteSand);
            this.grid.get(absoluteSand.x).set(absoluteSand.y, fallingSand);
            //printGrid();
        }
    }

    private boolean diagonalRightIsFree(Point absoluteSand) {
        try {
            if (this.grid.get(absoluteSand.x + 1).get(absoluteSand.y + 1).symbol == '.')
                return true;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Falling");
            return false;
        }
        return false;
    }

    private boolean diagonalLeftIsFree(Point absoluteSand) {
        try {
            if (this.grid.get(absoluteSand.x - 1).get(absoluteSand.y + 1).symbol == '.')
                return true;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Falling");
            return false;
        }
        return false;
    }

    private boolean fieldBelowIsFree(Point absoluteSand) {
        try {
            if (this.grid.get(absoluteSand.x).get(absoluteSand.y + 1).symbol == '.')
                return true;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Falling");
            return false;
        }
        return false;
    }

    public void setStartingPosition(Point startingPosition) {
        this.startingPosition = startingPosition;
    }

    public boolean isBlocked(){
        Point absouluteStart = absolute(startingPosition);
        Cell startCell=this.grid.get(absouluteStart.x).get(absouluteStart.y);
        if(startCell instanceof Sand &&
            ((Sand)startCell).isSettled)
            return true;
        return false;
    }
}
