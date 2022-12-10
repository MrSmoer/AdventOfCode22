package Days.Day9;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Map {
    int xSize;
    int ySize;
    Point sOffset;
    List<ArrayList<Character>> map;
    List<String> overlaps;

    public Map(List<MoveCommand> commandList) {
        this.overlaps= new ArrayList<>();
        this.map = new ArrayList<ArrayList<Character>>();
        generateMap(commandList);
    }

    public void generateMap(List<MoveCommand> commandList){
        this.getSizes(commandList);
        this.clearMap();
    }

    public void getSizes(List<MoveCommand> commandList) {
        Point highest = new Point();
        Point lowest = new Point();
        Head head = new Head();
        for (MoveCommand moveCommand : commandList) {
            for (int currentSteps = 0; currentSteps < moveCommand.steps(); currentSteps++) {
                head.moveOne(moveCommand.direction);
                if (head.x > highest.x)
                    highest.x = head.x;
                if (head.y > highest.y)
                    highest.y = head.y;
                if (head.x < lowest.x)
                    lowest.x = head.x;
                if (head.y < lowest.y)
                    lowest.y = head.y;
            }

        }

        this.xSize=highest.x-lowest.x+1;
        this.ySize=highest.y-lowest.y+1;
        this.sOffset=new Point(lowest.x*-1,lowest.y*-1);

    }

    public void placeRelative(Point p, char character){
        if(this.map.get(p.x+sOffset.x).get(p.y+sOffset.y)!='.')
            overlaps.add(this.map.get(p.x+sOffset.x).get(p.y+sOffset.y)+" overlaps "+character);
        else this.map.get(p.x+sOffset.x).set(p.y+sOffset.y,character);
    }

    public void clearMap() {
        this.map=new ArrayList<ArrayList<Character>>();
        this.overlaps= new ArrayList<>();
        for(int columns = 0; columns< this.xSize; columns++){
            ArrayList<Character> column = new ArrayList<Character>(ySize); 
            for(int row = 0; row<this.ySize;row++){
                column.add(row,'.');
            }
            this.map.add(columns,column);
        }
        this.placeRelative(new Point(),'s');
    }

    public void printMap() {
        for(String overlap : overlaps){
            System.out.println(overlap);
        }
        for(int row = this.ySize-1; row >= 0;row--){
            String thisLine = ""; 
            for(int columns = 0; columns< this.xSize; columns++){
                thisLine=thisLine+this.map.get(columns).get(row);
            }
            System.out.println(thisLine);
        }

        
        System.out.println("");
    }
}
