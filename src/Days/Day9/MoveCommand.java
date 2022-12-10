package Days.Day9;

public class MoveCommand {
    int steps;
    char direction;

    public MoveCommand(int steps, char direction){
        this.steps=steps;
        this.direction=direction;
    }

    public char direction(){
        return this.direction;
    }

    public int steps(){
        return this.steps;
    }
}
