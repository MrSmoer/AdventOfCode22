package Days.Day10;

import java.util.ArrayList;
import java.util.List;

public class Crt {
    int lineCounter;
    String currentLine;
    List<String> screen;

    public Crt(){
        this.screen=new ArrayList<>();
        this.currentLine="";
        this.lineCounter=0;
    }

    public void drawPixel(int xRegister) {
        if(this.currentLine.length()>=40){
            this.screen.add(this.currentLine);
            this.currentLine="";
        }
        if(currentLine.length()+1>=xRegister&& currentLine.length()-1<=xRegister)
            this.currentLine+='#';
        else
            this.currentLine+='.';
        
    }

    public void addLastLine(){
        this.screen.add(this.currentLine);
    }

    public void printScreen(){
        for(String line : screen){
            System.out.println(line);
        }
    }
}
