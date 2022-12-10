package Days.Day10.Instructions;

public class Instruction {
    int cycles=1;
    String name;
    String args;
    

    public Instruction(String name, String args) {
        this.name=name;
        this.args=args;
    }
    public boolean cycle(){
        this.cycles--;
        return cycles<=0;
    }
    public int execute(int xregister){
        return xregister;
    }

    public String getInstructionName(){
        return this.name;
    }
}
