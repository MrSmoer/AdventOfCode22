package Days.Day7;

import java.util.concurrent.ConcurrentHashMap;


public class Directory extends FileObject{

    ConcurrentHashMap<String,FileObject> content;
    public Directory() {
        this.content=new ConcurrentHashMap<String,FileObject>();
    }

    @Override
    public int getSize() {
        int size = 0;
        for (String filename : this.content.keySet()) {
            if (!filename.equals("..")&&!filename.equals("/"))
                size += this.content.get(filename).getSize();
        }
        return size;
    }

    public boolean addObject(String name, FileObject object) {
        this.content.put(name, object);
        return true;
    }

    public FileObject getChild(String name) {
        return this.content.get(name);
    }
    
}
