package Days.Day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class First {

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
        ArrayList<ContainerPair> pairs = new ArrayList<ContainerPair>();
        int pairIndex = 1;
        try {

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(""))
                    continue;
                PackageContainer container1 = buildPackageContainer(line);
                PackageContainer container2 = buildPackageContainer(bufferedReader.readLine());
                pairs.add(new ContainerPair(pairIndex, container1, container2));
                pairIndex++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = 0;
        for(ContainerPair pair : pairs){
            Boolean returned=pair.compare(pair.firstContainer, pair.secondContainer);
            System.out.println("Pair "+pair.index+" is in "+returned+" order");
            if(returned){
                result+=pair.index;
            }
        }

        return result;

    }

    static int index;

    public static PackageContainer buildPackageContainer(String input){
        index = -1;
        String a = input.substring(1, input.length() - 1);
        return handleItem(a);

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