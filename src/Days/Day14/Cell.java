package Days.Day14;

import java.awt.Point;

public class Cell {
    Point position;

    public Cell(){
        this.position=new Point();
    }

    public Cell(Point position){
        this.position=position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }


}
