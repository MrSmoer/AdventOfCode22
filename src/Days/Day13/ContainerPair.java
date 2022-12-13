package Days.Day13;

import java.util.ArrayDeque;

public class ContainerPair {
    PackageContainer firstContainer;
    PackageContainer secondContainer;
    int index;

    public ContainerPair(int index, PackageContainer firstpair, PackageContainer secondPair) {
        this.index = index;
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;

    }

    public Boolean compare(PackageContainer first, PackageContainer second) {
        PackageContainer item1 = first;
        PackageContainer item2 = second;
        int intCount = 0;
        if (item1 instanceof IntegerPackage || item2 instanceof IntegerPackage) {
            if (item1 instanceof IntegerPackage && item2 instanceof ListPackage) {
                item1 = new ListPackage((IntegerPackage) first);
            } else if (item2 instanceof IntegerPackage && item1 instanceof ListPackage) {
                item2 = new ListPackage((IntegerPackage) second);
            }
            return compare(first, second);
            //Integer 
        } else if (item1 instanceof IntegerPackage && item2 instanceof IntegerPackage) {
            if(((IntegerPackage)item1).getContent()<((IntegerPackage)item2).getContent()){
                return true;
            } else if(((IntegerPackage)item1).getContent()==((IntegerPackage)item2).getContent()){
                return null;
            } else if(((IntegerPackage)item1).getContent()>((IntegerPackage)item2).getContent()){
                return false;
            }
        } else {
            ArrayDeque<PackageContainer> firstList = ((ListPackage) item1).getContent();
            ArrayDeque<PackageContainer> secondList = ((ListPackage) item2).getContent();
            for (int itemCount = 0; itemCount < firstList.size(); itemCount++) {

            }
        }
        return true;

    }
}
