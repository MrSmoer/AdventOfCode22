package Days.Day15;

import java.awt.Point;

public class Sensor extends Cell{
    Beacon closestBeacon;
    
    int reachDistance;

    public Sensor(Point position, Beacon closestBeacon) {
        super(position, 'S');
        this.closestBeacon=closestBeacon;
        this.reachDistance=0;
        
    }

    public int distanceToBeacon(){
        int xDist = this.closestBeacon.position.x-this.position.x;
        int yDist = this.closestBeacon.position.y-this.position.y;

        if(xDist<0){
            xDist=-1*xDist;
        }
        if(yDist<0){
            yDist=-1*yDist;
        }
        return xDist+yDist;
    }

    boolean hasReachedBeacon(){
        return reachDistance>=distanceToBeacon();
    }
    
}
