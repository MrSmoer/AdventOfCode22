package Days.Day05;

public class Instruction {
    int quantity;
    int sourceStack;
    int targetStack;

    public Instruction(int quantity, int sourceStack, int targetStack){
        this.quantity = quantity;
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSourceStack() {
        return sourceStack;
    }
    public void setSourceStack(int sourceStack) {
        this.sourceStack = sourceStack;
    }
    public int getTargetStack() {
        return targetStack;
    }
    public void setTargetStack(int targetStack) {
        this.targetStack = targetStack;
    }

}
