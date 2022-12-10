package Days.Day10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import Days.Day10.Instructions.Instruction;
import Days.Day10.Instructions.addxInstruction;

public class Cpu {
    Deque<Instruction> instructions;
    ConcurrentHashMap<String, Instruction> instructionMap;
    Instruction loadedInstruction;
    Deque<Instruction> executionDeque;
    
    int instructionCounter;
    int xRegister;
    
    public Cpu(Deque<Instruction> instructions){
        this.executionDeque = new ArrayDeque<Instruction>();
        this.instructions= instructions;
        this.xRegister=1;
        loadNewInstruction();
        
    }

    public boolean cycle(){
        if(this.executionDeque.size()>0){
            this.xRegister=executionDeque.pollFirst().execute(this.xRegister);
        }
        if(this.loadedInstruction.cycle()){
            this.executionDeque.add(this.loadedInstruction);
            return loadNewInstruction();
        }
        return true;
    }
    
    private boolean loadNewInstruction() {
        this.loadedInstruction=this.instructions.pollFirst();
        return hasNewInstruction();
    }

    public boolean hasNewInstruction(){
        if(this.instructions.size()<1)
            return false;
        else 
            return true;
    }

    public void addInstructionToExecute(Instruction newInstruction){
        this.instructions.add(newInstruction);
    }
    
}
