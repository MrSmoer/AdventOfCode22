package Days.Day11;

public class Item {
    int worryLevel;
    int monkeyDestination;
    public Item(int worryLevel, int monkeyDestination){
        this.worryLevel=worryLevel;
        this.monkeyDestination=monkeyDestination;
    }
    public int getWorryLevel() {
        return worryLevel;
    }
    public void setWorryLevel(int worryLevel) {
        this.worryLevel = worryLevel;
    }
    public int getMonkeyDestination() {
        return monkeyDestination;
    }
    public void setMonkeyDestination(int monkeyDestination) {
        this.monkeyDestination = monkeyDestination;
    }
}
