package Days.Day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import java.awt.Point;

public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day15/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day15/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        ArrayList<Cell> itemInTargetLine= new ArrayList<>();
        String readLine;
        ArrayList<ArrayList<Cell>> grid = new ArrayList<ArrayList<Cell>>();
        ArrayList<Beacon> beacons = new ArrayList<Beacon>();
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        Point startingPosition = new Point(0, 0);
        int targetLine = 2000000;
        Sensor mostdistance = null;
        try {

            while ((readLine = bufferedReader.readLine()) != null) {

                String[] elements = readLine.split(" at ");
                ArrayList<Point> pair = new ArrayList<>();
                for (int i = 1; i < 3; i++) {
                    Point newPoint = convertPoint(elements[i].split(":")[0]);
                    
                    pair.add(newPoint);
                }
                boolean isInList = false;
                Beacon beacon = new Beacon(pair.get(1));
                for (Beacon beacon2 : beacons) {
                    if (beacon.getPosition().x == beacon2.getPosition().x
                            && beacon.getPosition().y == beacon2.getPosition().y) {
                        beacon = beacon2;
                        isInList = true;
                        continue;
                    }
                }
                if (!isInList) {
                    if(beacon.position.y==targetLine){
                        itemInTargetLine.add(beacon);
                    }
                    beacons.add(beacon);
                }
                Sensor sensor = new Sensor(pair.get(0), beacon);
                if(sensor.position.y==targetLine){
                    itemInTargetLine.add(sensor);
                }
                sensors.add(sensor);
            }
            ArrayList<Sensor> toRemove = new ArrayList<Sensor>();
            for (Sensor sensor : sensors) {
                int distanceToBeacon = sensor.distanceToBeacon();

                int distanceToTarget = targetLine - sensor.position.y - 1;
                if (distanceToBeacon < distanceToTarget) {
                    toRemove.add(sensor);
                } else {
                    if (mostdistance == null || distanceToBeacon > mostdistance.distanceToBeacon()) {
                        mostdistance = sensor;
                    }
                }
            }
            System.out.println(mostdistance.distanceToBeacon());
            for (Sensor sensor : toRemove) {
                sensors.remove(sensor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Range> ranges = new ArrayList<Range>();
        for (Sensor sensor : sensors) {
            int distanceToBeacon = sensor.distanceToBeacon();
            int x = sensor.position.x;
            Integer distanceLines = absInteger(sensor.position.y - targetLine);
            int charactersToDraw = distanceToBeacon - distanceLines;
            if (charactersToDraw >= 0)
                ranges.add(new Range(x, charactersToDraw));

        }

        int result = 0;
        ArrayList<Range> trimmedRanges = new ArrayList<Range>();
        for (Range range : ranges) {
            System.out.print("m");
            range.print(true);
            for (Range otherRange : ranges) {
                if (otherRange == range) {
                    continue;
                }
                if (range != null && otherRange != null) {
                    range.print();
                    otherRange.print();
                    range = range.trimOverlaps(otherRange);
                    if (range != null)
                        range.print();
                    else
                        System.out.println("NUll");
                }
            }
            if (range != null)
                trimmedRanges.add(range);
        }

        for (Range range : trimmedRanges) {
            ArrayList<Cell> itemsToRemove = new ArrayList<Cell>();
            for(Cell itemInLine : itemInTargetLine){
                if(range.containsInt(itemInLine.position.x))
                {
                    result--;
                    itemsToRemove.add(itemInLine);
                }
            }

            for(Cell itemToRemove: itemsToRemove){
                itemInTargetLine.remove(itemToRemove);
            }
            // TODO subtract other stuff within
            result += range.size();
        }

        System.out.println("test");

        return result;

    }

    public static Integer absInteger(int i) {
        if (i < 0)
            return i * -1;
        return i;
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