package Days.Day14;


import java.awt.Point;
import java.util.ArrayList;
public class Line {
    ArrayList<Point> points;

    public Line(){
        this.points= new ArrayList<Point>();

    }

    public void addPoint(Point p){
        this.points.add(p);
    }

    public Point getPointAtI(int index){
        if(index<this.points.size()){

            return this.points.get(index);
        }
        return null;
    }
}
