package Days.Day5;

import java.util.ArrayDeque;
import java.util.Deque;

public class PortStorage {
    Deque<Character>[] storDeques;
    @SuppressWarnings("unchecked")
    PortStorage(int size){
        this.storDeques = (Deque<Character>[]) new ArrayDeque[size];
    }

    public void addStack(int stackNumber, Deque<Character> stack){
        this.storDeques[stackNumber]=stack;
    }

    public void addToStack(int stackNumber,char item){
        if(this.storDeques[stackNumber-1].add(item))
        ;//System.out.println("Success!");
        else System.out.println("No success");
    }

    public Character removeTopFromStack(int stackNumber){
        Character c = this.storDeques[stackNumber-1].removeLast();

        return c;
    }

    public void moveItemFromStackToStack(int firstStack, int secondStack){
        addToStack(secondStack, removeTopFromStack(firstStack));

    }

    public String getTopBoxes(){
        String result = "";
        for(Deque<Character> stack : this.storDeques){
            result=result+stack.peekLast();
        }
        return result;
    }

}
