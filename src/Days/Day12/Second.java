package Days.Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import java.awt.Point;

public class Second {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
             positionCount = solve(provideBufferedReader("src/Days/Day12/input.txt"));
            //positionCount = solve(provideBufferedReader("src/Days/Day12/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String line;
        ArrayList<ArrayList<MapPoint>> map = new ArrayList<ArrayList<MapPoint>>();
        ArrayList<MapPoint> mapLine;
        MapPoint start = null;
        MapPoint end = null;
        ArrayList<MapPoint> starts = new ArrayList<MapPoint>();
        try {
            int rowCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                int columnCounter = 0;
                mapLine = new ArrayList<MapPoint>();
                for (char character : line.toCharArray()) {
                    MapPoint thisPoint = new MapPoint(character);
                    thisPoint.setPosition(new Point(columnCounter, rowCounter));
                    if (character == 'a') {
                        starts.add(thisPoint);
                    } else if (character == 'S') {
                        start = thisPoint;
                        starts.add(thisPoint);
                    } else if (character == 'E') {
                        end = thisPoint;
                    }
                    mapLine.add(thisPoint);
                    columnCounter++;
                }
                map.add(mapLine);
                rowCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (start == null || end == null)
            return 0;

        int totalChars = 0;
        for (ArrayList<MapPoint> row : map) {
            totalChars += row.size();
        }
        int shortestPathCount = totalChars;
        for (MapPoint neustart : starts) {
            neustart.setVisitedBefore(true);
            boolean hasNotReached = true;
            int stepCount = 1;
            ArrayDeque<MapPoint> steppedOn = new ArrayDeque<>();
            steppedOn.add(neustart);
            List<MapPoint> thingsToAdd;
            List<MapPoint> thingsToRemove;

            searchbiggest:
            while (hasNotReached && stepCount < totalChars + 1) {
                thingsToAdd = new ArrayList<MapPoint>();
                thingsToRemove = new ArrayList<MapPoint>();
                for (MapPoint steppedOnPoint : steppedOn) {
                    ArrayDeque<MapPoint> steppables = getSteppableNeighbours(steppedOnPoint, map);

                    if (steppables.size() == 0)
                        thingsToRemove.add(steppedOnPoint);

                    for (MapPoint stepNeighbour : steppables) {
                        if ((int) stepNeighbour.getHeight() == (int) 'E')
                            break searchbiggest;
                        stepNeighbour.setStepCount(stepCount);
                        stepNeighbour.setVisitedBefore(true);
                        thingsToAdd.add(stepNeighbour);

                    }
                }
                for (MapPoint point : thingsToAdd) {
                    if (!steppedOn.contains(point))
                        steppedOn.add(point);
                }
                for (MapPoint point : thingsToRemove) {
                    if (steppedOn.contains(point))
                        steppedOn.remove(point);
                }
                stepCount++;
            }
            
            if(stepCount<shortestPathCount){
                shortestPathCount=stepCount;
            }
            map=clearAllSteps(map);
        }


        return shortestPathCount;
    }

    private static ArrayList<ArrayList<MapPoint>> clearAllSteps(ArrayList<ArrayList<MapPoint>> map) {
        for (ArrayList<MapPoint> row : map) {
            for (MapPoint point : row) {
                point.setStepCount(0);
                point.setVisitedBefore(false);
            }
        }
        return map;
    }


    private static ArrayDeque<MapPoint> getSteppableNeighbours(MapPoint steppedOnPoint,
            ArrayList<ArrayList<MapPoint>> map) {
        ArrayDeque<MapPoint> neighbours = new ArrayDeque<MapPoint>();
        Point thisPosition = steppedOnPoint.getPosition();
        char thisHeight = steppedOnPoint.getHeight();
        int x = thisPosition.x;
        int y = thisPosition.y;
        if (x > 0) {
            neighbours.add(map.get(thisPosition.y).get(thisPosition.x - 1));
        }
        if (x < map.get(0).size() - 1) {
            neighbours.add(map.get(thisPosition.y).get(thisPosition.x + 1));
        }
        if (y > 0) {
            neighbours.add(map.get(thisPosition.y - 1).get(thisPosition.x));
        }
        if (y < map.size() - 1) {
            neighbours.add(map.get(thisPosition.y + 1).get(thisPosition.x));
        }
        List<MapPoint> thingsToRemove = new ArrayList<>();
        ;
        for (MapPoint poiint : neighbours) {
            char pointHeight = poiint.getHeight();
            if (poiint.visitedBefore) {
                thingsToRemove.add(poiint);
                continue;
            }
            if (thisHeight != 'S' && (pointHeight - 1 > thisHeight || (pointHeight == 'E' && thisHeight < 'y'))) {
                thingsToRemove.add(poiint);
                continue;
            }

        }
        if (thingsToRemove != null)
            for (MapPoint toRemove : thingsToRemove)
                neighbours.remove(toRemove);
        return neighbours;

    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}