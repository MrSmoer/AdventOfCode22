package Days.Day13;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ListPackage extends PackageContainer{
    ArrayList<PackageContainer> content;

    public ListPackage() {
        this.content = new ArrayList<PackageContainer>();
    }
    public ListPackage(ArrayList<PackageContainer> content) {
        this.content = content;
    }

    public ListPackage(PackageContainer content) {
        this.content= new ArrayList<PackageContainer>();
        this.addContainer(content);
    }

    public void addContainer(PackageContainer container){
        this.content.add(container);
    }
    public ArrayList<PackageContainer> getContent(){
        return this.content;
    }

}
