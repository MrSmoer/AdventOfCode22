package Days.Day13;

import java.util.ArrayList;

public class ContainerPair {
    PackageContainer firstContainer;
    PackageContainer secondContainer;
    int index;

    public ContainerPair(int index, PackageContainer firstContainer, PackageContainer secondContainer) {
        this.index = index;
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;

    }

    public Boolean compare(PackageContainer first, PackageContainer second) {
        PackageContainer item1 = first;
        PackageContainer item2 = second;
        if (item1 instanceof IntegerPackage ^ item2 instanceof IntegerPackage) {
            // GENAU 1 INTEGER -> anders umwandeln und vergleichen
            if (item1 instanceof IntegerPackage && item2 instanceof ListPackage) {
                item1 = new ListPackage((IntegerPackage) first);
            } else if (item2 instanceof IntegerPackage && item1 instanceof ListPackage) {
                item2 = new ListPackage((IntegerPackage) second);
            }
            return compare(item1, item2);
        } else if (item1 instanceof IntegerPackage && item2 instanceof IntegerPackage) {
            // BEIDE integer -> vergleichen
            if (((IntegerPackage) item1).getContent() < ((IntegerPackage) item2).getContent()) {
                return true;
            } else if (((IntegerPackage) item1).getContent() == ((IntegerPackage) item2).getContent()) {
                return null;
            } else if (((IntegerPackage) item1).getContent() > ((IntegerPackage) item2).getContent()) {
                return false;
            }

        } else {
            // BEIDE LISTE
            Boolean decision = null;
            ArrayList<PackageContainer> firstList = ((ListPackage) item1).getContent();
            ArrayList<PackageContainer> secondList = ((ListPackage) item2).getContent();
            int size1 = firstList.size();
            int size2 = secondList.size();
            int size = size1;
            Boolean isShorter = null;
            if (size1 < size2){
                isShorter=true;
                size = size1;
            }else if(size1> size2){
                isShorter=false;
                size = size2;
            }
            for (int itemCount = 0; itemCount < size; itemCount++) {
                decision = compare(firstList.get(itemCount), secondList.get(itemCount));
                if (decision != null) {
                    return decision;
                }
            }
            if(isShorter!=null){
                return isShorter;
            }
            if (decision == null) {
                return null;
            }
        }
        return null;

    }
}
