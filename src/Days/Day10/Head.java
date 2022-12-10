package Days.Day10;

import java.awt.Point;

public class Head extends Point {
    public void moveOne(char direction) {
        int xDistance = 0;
        int yDistance = 0;
        if (direction == 'U') {
            yDistance = 1;
        } else if (direction == 'D') {
            yDistance = -1;
        } else if (direction == 'L') {
            xDistance = -1;
        } else if (direction == 'R') {
            xDistance = 1;
        }
            this.setLocation(this.x + xDistance, this.y + yDistance);
    }

}
