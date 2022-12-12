package Days.Day12;

import java.awt.Point;


public class MapPoint {
    Point position;
    boolean visitedBefore;
    char height;
    int stepCount;

    public MapPoint(char height){
        this.height=height;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isVisitedBefore() {
        return visitedBefore;
    }

    public void setVisitedBefore(boolean visitedBefore) {
        this.visitedBefore = visitedBefore;
    }

    public char getHeight() {
        return height;
    }

    public void setHeight(char height) {
        this.height = height;
    }

    

    
}
