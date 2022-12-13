package Days.Day13;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    private static ArrayList<PackageContainer> inputArray = new ArrayList<PackageContainer>();

    public QuickSort(ArrayList<PackageContainer> inputArray) {
            QuickSort.inputArray = inputArray;
    }

    public void startQuickStart(int start, int end) {
        int q;
        if (start < end) {
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q + 1, end);
        }
    }

    public ArrayList<PackageContainer> getSortedArray() {
        return QuickSort.inputArray;
    }

    public int partition(int start, int end) {
        System.out.println("\n---------Iteration Starts----------");
        System.out.println("\nSorting Window from index number:" + start + " to " + end);

        int init = start;
        int length = end;

        Random r = new Random();
        int pivotIndex = nextIntInRange(start, end, r);
        PackageContainer pivot = inputArray.get(pivotIndex);

        System.out.println("Pivot Element " + pivot + " at index:" + pivotIndex);

        while (true) {
            while (isBigger(inputArray.get(length),pivot) && length > start) {
                length--;
            }

            while (isBigger(pivot,inputArray.get(init))&& init < end) {
                init++;
            }

            if (init < length) {
                PackageContainer temp;
                temp = inputArray.get(init);
                inputArray.set(init, inputArray.get(length));
                inputArray.set(length, temp);
                length--;
                init++;

                System.out.println("\nAfter Swapping");
                for (int i = start; i <= end; i++) {
                    System.out.print(inputArray.get(i) + " ");
                }
            } else {
                System.out.println("\n---------Iteration Ends---------");
                return length;
            }
        }

    }

    // Below method is to just find random integer from given range
    static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }

    public boolean isBigger(PackageContainer first, PackageContainer second){
        Boolean b = compare(second, first);
        if(b!=null)
            return b;
        else return false;

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
                System.out.println("equal");
                return null;
            }
        }
        return null;

    }
}