package Days.Day14;

import java.awt.Point;

public class Cell {
    Point position;
    char symbol;
    public Cell(char symbol){
        this.symbol=symbol;
        this.position=new Point();
    }



    public Cell(Point position,char symbol){
        this.position=position;
        this.symbol=symbol;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }


}
