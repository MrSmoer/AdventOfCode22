package Days.Day15;

import java.awt.Point;

public class Sensor extends Cell{
    Beacon closestBeacon;

    public Sensor(Point position, Beacon closestBeacon) {
        super(position, 'S');
        this.closestBeacon=closestBeacon;
        
    }
    
}
