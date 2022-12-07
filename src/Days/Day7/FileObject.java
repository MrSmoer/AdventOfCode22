package Days.Day7;

import java.util.ArrayList;
import java.util.List;

public class FileObject {
    List<FileObject> content;
    boolean isFile;
    int size;
    public FileObject(){
        this.isFile=false;
        this.content=new ArrayList<FileObject>();
        this.size=0;
    }
    public FileObject(int size){
        this.isFile=true;
        this.content=new ArrayList<FileObject>();
        this.size=size;
    }

    public boolean addObject(FileObject object){
        if(this.isFile)
            return false;
        this.content.add(object);
        //this.calculateSize();
        return true;
    }

    public int calculateSize(){
        if(!this.isFile){
            int newSize = 0;
            for (FileObject object : this.content){
                newSize+=object.calculateSize();
            }
            this.size=newSize;
        }
        return this.size;
    }
    
}
