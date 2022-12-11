package Days.Day11;

public class Item {
    long worryLevel;
    int monkeyDestination;
    int remainder;
    public Item(int worryLevel, int monkeyDestination){
        this.worryLevel=worryLevel;
        this.monkeyDestination=monkeyDestination;
    }
    public int getRemainder() {
        return remainder;
    }
    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
    public long getWorryLevel() {
        return worryLevel;
    }
    public void setWorryLevel(long worryLevel) {
        this.worryLevel = worryLevel;
    }
    public int getMonkeyDestination() {
        return monkeyDestination;
    }
    public void setMonkeyDestination(int monkeyDestination) {
        this.monkeyDestination = monkeyDestination;
    }
}
