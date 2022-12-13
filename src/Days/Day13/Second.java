package Days.Day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Second {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day13/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day13/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String line;
        ArrayList<PackageContainer> pairs = new ArrayList<PackageContainer>();
        int pairIndex = 1;
        try {

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(""))
                    continue;
                PackageContainer container1 = buildPackageContainer(line);
                pairs.add(container1);

            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        PackageContainer firstMarker = buildPackageContainer("[[2]]");
            PackageContainer secondMarker = buildPackageContainer("[[6]]");
            pairs.add(firstMarker);
            pairs.add(secondMarker);

        int result = 0;
        QuickSort qs = new QuickSort(pairs);
        qs.startQuickStart(0, pairs.size()-1);

        int firstIndex=1;
        while(qs.getSortedArray().get(firstIndex-1)!=firstMarker){
            firstIndex++;
        }
        int secondIndex=1;
        while(qs.getSortedArray().get(secondIndex-1)!=secondMarker){
            secondIndex++;
        }
        //qs.getSortedArray();
        result=firstIndex*secondIndex;
        ArrayList<PackageContainer> list = qs.getSortedArray();
        printArray(list);
        return result;

    }

    static int index;

    public static PackageContainer buildPackageContainer(String input){
        index = -1;
        String a = input.substring(1, input.length() - 1);
        return handleItem(a);

    }

    public static void printArray(ArrayList<PackageContainer> list){
        String line = "";
        for(PackageContainer container :list){
            
            System.out.println(getListContent((ListPackage)container));
        }

    }

    public static String getListContent(ListPackage packae){
        String line = "";
        for(PackageContainer conainer : packae.getContent()){
            if(conainer instanceof IntegerPackage){
                line+=((IntegerPackage)conainer).getContent()+",";
            }else{
                line+="[";
                line+=getListContent((ListPackage)conainer);
                if (line.charAt(line.length()-1)==',')
                    line= line.substring(0, line.length()-1);
                line+="]";
                return line;
            }
        }
        return line;

    }

    public static PackageContainer handleItem(String content) {
        ArrayList<PackageContainer> containerList = new ArrayList<PackageContainer>();
        char[] items = content.toCharArray();
        while(index< items.length-1){
            index++;
            if(items[index]=='['){
                containerList.add(handleItem(content));
            }else if(Character.isDigit(items[index])){
                String number = items[index]+"";
                while(index<items.length-1&&Character.isDigit(items[index+1])){
                    index++;
                    number+=items[index];
                }
                containerList.add(new IntegerPackage(Integer.parseInt(number)));
            }else if(items[index]==']'){
                return new ListPackage(containerList);
            }
        }

        return new ListPackage(containerList);
    }

    public static String restOfArrayJoined(String[] array, int index) {
        String s = "";
        for (int i = index; i < array.length; i++) {
            s += array[i] + ",";

        }
        s = s.substring(1, s.length() - 1);
        return s;
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}