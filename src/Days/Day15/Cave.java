package Days.Day15;

import java.util.ArrayList;

import Days.Day08.Direction;

import java.awt.Point;

public class Cave {
    ArrayList<ArrayList<Cell>> grid;
    Point cordsOfTopLeft;
    Point startingPosition;

    Point UP;
    Point RIGHT;
    Point LEFT;
    Point DOWN;

    Point RIGHTUP;
    Point RIGHTDOWN;
    Point LEFTDOWN;
    Point LEFTUP;

    public Cave() {
        this.grid = new ArrayList<ArrayList<Cell>>();
        this.UP = new Point(0, -1);
        this.RIGHT = new Point(1, 0);
        this.LEFT = new Point(-1, 0);
        this.DOWN = new Point(0, 1);
        this.RIGHTUP = add(this.RIGHT, this.UP);
        this.RIGHTDOWN = add(this.RIGHT, this.DOWN);
        this.LEFTDOWN = add(this.LEFT, this.DOWN);
        this.LEFTUP = add(this.LEFT, this.UP);
    }

    public Point add(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
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
        // cell.setPosition(relativePoint);
        if (!(this.grid.get(relativePoint.x).get(relativePoint.y) instanceof Beacon))
            this.grid.get(relativePoint.x).set(relativePoint.y, cell);
    }

    public void printGrid() {
        System.out.println(cordsOfTopLeft);
        for (int y = 0; y < this.grid.get(0).size(); y++) {
            int lineNumber = y + this.cordsOfTopLeft.y;
            String outputLine = " " + lineNumber;
            if (lineNumber < 10 && lineNumber > -1)
                outputLine = " " + outputLine;
            if (lineNumber < -9) {
                outputLine = outputLine.substring(1);
            }
            outputLine += " ";
            for (int x = 0; x < this.grid.size(); x++) {
                outputLine += this.grid.get(x).get(y).symbol;
            }
            System.out.println(outputLine);
        }
    }

    public void reachOut(ArrayList<Sensor> sensors) {
        boolean runAlready = false;
        while (true) {
            boolean allHaveReached = true;
            for (Sensor sensor : sensors) {
                boolean hasReachedBeacon = sensor.hasReachedBeacon();
                if (!hasReachedBeacon) {
                    int currentReachDistance = sensor.reachDistance + 1;
                    drawDiamond(sensor, currentReachDistance);
                    sensor.reachDistance = currentReachDistance;
                }
                allHaveReached = allHaveReached && hasReachedBeacon;

            }
            printGrid();
            if (allHaveReached) {
                if (runAlready)
                    break;
                else
                    runAlready = true;
            }
            System.out.println("asdf");

        }
    }

    public void drawDiamond(Sensor sensor, int currentReachDistance) {
        Point position = new Point(sensor.position.x - currentReachDistance, sensor.position.y);

        ArrayList<Point> directions = new ArrayList<Point>();
        directions.add(this.RIGHTUP);
        directions.add(this.RIGHTDOWN);
        directions.add(this.LEFTDOWN);
        directions.add(this.LEFTUP);

        for (Point direction : directions) {
            for (int i = 0; i < currentReachDistance; i++) {
                position = add(position, direction);
                Cell cell = new Cell('#');
                cell.position = position;
                this.drawObject(position, cell);
            }
        }
    }
}
