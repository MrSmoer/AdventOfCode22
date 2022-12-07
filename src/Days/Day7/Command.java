package Days.Day7;

import java.util.ArrayList;
import java.util.List;

public class Command {
    List<String> outPut;
    CommandType command;
    public Command(CommandType command){
        this.command = command;
        this.outPut=new ArrayList<String>();
    }

    public void setOutput(String outputLine){
        this.outPut.add(outputLine);
    }

    public List<String> getOutPut() {
        return outPut;
    }

    public void setOutPut(List<String> outPut) {
        this.outPut = outPut;
    }

    public CommandType getCommand() {
        return command;
    }

    public void setCommand(CommandType command) {
        this.command = command;
    }

    
}
