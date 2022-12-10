package Days.Day09;

import java.awt.Point;

public class Tail extends Point {
    int knotCount;
    Tail knotAbove;

    public Tail(int knotCount, Tail knotAbove) {
        this.knotCount = knotCount;
        this.knotAbove = knotAbove;
    }

    public boolean isNotCloseToAbove() {
        if (this.knotAbove == null) {
            return true;
        }
        int headX = this.knotAbove.x;
        int headY = this.knotAbove.y;
        int xdist = absolute(this.x - headX);
        int ydist = absolute(this.y - headY);

        if (xdist > 1 || ydist > 1)
            return true;

        return false;
    }

    public void updateLocation(Point oldHeadPoint) {
        if (this.knotCount == 1) {
            if (this.isNotCloseToAbove()) {
                this.moveTowardsAbove();
            }
        } else {
            if (this.knotAbove != null)
                this.knotAbove.updateLocation(oldHeadPoint);
            if (this.isNotCloseToAbove()) {
                    this.moveTowardsAbove();
            }
        }
    }

    public void moveTowardsAbove() {
        int xdiste = this.knotAbove.x - this.x;
        int ydiste = this.knotAbove.y - this.y;
        if(xdiste!=0)
        this.setLocation(this.x + xdiste / absolute(xdiste), this.y);
        if(ydiste!=0)
        this.setLocation(this.x, this.y + ydiste / absolute(ydiste));
    }

    public int absolute(int i) {
        int v;
        if (i < 0) {
            v = i * -1;
        } else {
            v = i;
        }
        return v;
    }
}
