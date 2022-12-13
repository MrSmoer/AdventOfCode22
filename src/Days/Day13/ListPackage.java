package Days.Day13;

import java.util.ArrayDeque;

public class ListPackage extends PackageContainer{
    ArrayDeque<PackageContainer> content;

    public ListPackage() {
        this.content = new ArrayDeque<PackageContainer>();
    }

    public ListPackage(PackageContainer content) {
        this.content= new ArrayDeque<PackageContainer>();
        this.addContainer(content);
    }

    public void addContainer(PackageContainer container){
        this.content.add(container);
    }
    public ArrayDeque<PackageContainer> getContent(){
        return this.content;
    }

}
