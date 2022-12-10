package Days.Day8;

import java.awt.Point;
import java.util.List;

public class ScoreEvaluator {
    Point point;
    Direction direction;
    int foundTrees;
    int highestTree;
    int test;
    List<List<Tree>> forest;

    public ScoreEvaluator(int x, int y, Direction direction, List<List<Tree>> forest) {
        this.point = new Point(x, y);
        this.direction = direction;
        this.foundTrees = 0;
        this.forest = forest;
        this.resetHighestTree();
    }

    public void move(int x, int y) {
        this.point.move(this.getTreeInRow() + x, this.getRow() + y);
    }

    public boolean walk() {
        int x = (int) this.point.getX();
        int y = (int) this.point.getY();
        switch (direction) {
            case UP:
                if (y - 1 < 0)
                    return false;
                this.move(0, -1);
                break;

            case DOWN:
                if (this.forest.size() - y <= 1)
                    return false;
                this.move(0, 1);
                break;

            case LEFT:
                if (x - 1 < 0)
                    return false;
                this.move(-1, 0);
                break;

            case RIGHT:
                if (this.getDirectionSize() - x <= 1)
                    return false;
                this.move(1, 0);
                break;

            default:
                System.out.println("Wierd direction");
        }
        return true;
    }

    public boolean sidestep() {
        Direction olDirection = this.direction;
        if (this.direction == Direction.UP || this.direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
        } else {
            this.direction = Direction.DOWN;
        }
        boolean result = walk();
        this.direction = olDirection;
        return result;
    }

    public int getRow() {
        return (int) this.point.getY();
    }

    public int getTreeInRow() {
        return (int) this.point.getX();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void walkWholeDirection() {
        this.setLocation(this.getHome());
        int directionSize = getOtherDirectionSize();
        for (int i = 0; i < directionSize; i++) {
            this.sidestep();
            this.walkRow();
        }
    }

    private int getOtherDirectionSize() {
        Direction olDirection = this.direction;
        if (this.direction == Direction.UP || this.direction == Direction.DOWN)
            this.direction = Direction.RIGHT;
        else
            this.direction = Direction.DOWN;
        int size = getDirectionSize();
        this.direction = olDirection;
        return size;
    }

    public int getDirectionSize() {
        int directionSize = 0;
        if (this.direction == Direction.UP || this.direction == Direction.DOWN)
            directionSize = forest.size();
        else
            directionSize = forest.get(0).size();
        return directionSize;
    }

    public Point getHome() {
        Point homePoint = new Point();
        int directionSize = getDirectionSize();
        if (this.direction == Direction.DOWN)
            homePoint.setLocation(-1, -1);
        else if (this.direction == Direction.UP)
            homePoint.setLocation(-1, directionSize);
        else if (this.direction == Direction.RIGHT)
            homePoint.setLocation(-1, -1);
        else if (this.direction == Direction.LEFT)
            homePoint.setLocation(directionSize, -1);
        return homePoint;
    }

    public void setLocation(Point p) {
        this.point.setLocation(p);
    }

    public void walkRow() {
        Tree startingTree  = forest.get(this.getRow()).get(this.getTreeInRow());
        Point oldLocation = new Point(this.point.getLocation());
        int thisTreeHeight=startingTree.height;
        int thisTreeScore=startingTree.scenicScore;
        /*if (!this.backstep()) {
            currentTree.setScenicScore(0);
        }*/
        Tree currentTree;
        int directionTrees = 0;
        boolean blocked = false;
        while (walk()&&!blocked) {
            currentTree = forest.get(this.getRow()).get(this.getTreeInRow());
            if (currentTree.getHeight() >= thisTreeHeight) {
                blocked=true;
            }
            directionTrees++;
        }
        
        this.point.setLocation(oldLocation);
        forest.get(this.getRow()).set(this.getTreeInRow(), new Tree(thisTreeHeight,thisTreeScore*directionTrees));
        this.resetHighestTree();
    }

    public void resetHighestTree() {
        this.highestTree = -1;
    }
}
