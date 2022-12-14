package Days.Day14;

public class Sand extends Cell{
    public Sand() {
        super('+');
    }

    boolean isSettled;
    public void setSettled(){
        this.isSettled=true;
        this.symbol='o';
    }
    
    
    
}
