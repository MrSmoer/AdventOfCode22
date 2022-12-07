package Days.Day7;

import java.util.ArrayList;
import java.util.List;

public class Command {
    List<String> output;
    CommandType type;
    String[] args;
    public Command(CommandType type, String[] args){
        this.args=args;
        this.type = type;
        this.output=new ArrayList<String>();
    }

    public void addOutputLine(String outputLine){
        this.output.add(outputLine);
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType command) {
        this.type = command;
    }

    
}
