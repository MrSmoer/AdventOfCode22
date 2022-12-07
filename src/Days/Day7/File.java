package Days.Day7;

public class File extends FileObject{
    int size;
    public File(int size){
        this.size=size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
    
}
