package Days.Day10.Instructions;

public class addxInstruction extends Instruction{
    
    public addxInstruction(String args){
        super("addx",args);
        this.cycles = 2;
    }

    @Override
    public int execute(int xregister) {
        String[] words = args.split(" ");
        int modifier = Integer.parseInt(words[1]);
        return xregister+modifier;
    }
}
