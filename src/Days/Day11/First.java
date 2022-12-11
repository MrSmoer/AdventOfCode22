package Days.Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class First {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day11/input.txt"));
             // positionCount = solve(provideBufferedReader("src/Days/Day11/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        String line;
        List<Monkey> monkeys = new ArrayList<>();
        ArrayDeque<String> lines = new ArrayDeque<String>();

        String test = "  Operation: new = old * old";
        System.out.println(test.replaceAll("old",10+""));
        try {
            while((line = bufferedReader.readLine())!=null){
                lines.add(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(lines.size()<1)
            return 0;

        ArrayDeque<String> currentMonkeySection = new ArrayDeque<>();
        for(String linen : lines){
            if(linen.equals("")){
                monkeys.add(createMonkey(currentMonkeySection));
                currentMonkeySection= new ArrayDeque<>();
            }else{
                currentMonkeySection.add(linen);
            }
        }
        if(currentMonkeySection.size()>0){
            monkeys.add(createMonkey(currentMonkeySection));
        }
        System.out.println();
        int rounds = 20;
        for(int roundCounter = 0; roundCounter<rounds; roundCounter++){
            for(Monkey currentMonkey : monkeys){
                for(Item titem : currentMonkey.items){
                    currentMonkey.investigateFirstItem();
                    currentMonkey.getBored();
                    currentMonkey.testWorryLevel();
                    currentMonkey.throwItem();
                    monkeys.get(titem.monkeyDestination).fetchItem(titem);
                }
            }
            System.out.println("Round: "+roundCounter);
            for(Monkey currentMonkey : monkeys){
                String itemString = "";
                for (Item currentItem:currentMonkey.items){
                    itemString+=currentItem.getWorryLevel()+", ";
                }
                System.out.println("Monkey "+currentMonkey.monkeyName+": "+itemString);
            }
        }
        int nHighestMonkeys= 2;
        List<Monkey> highMonkeys = new ArrayList<>();
        for(int i = 0; i<nHighestMonkeys; i++){
            Monkey highMonkey = getHighestMonkey(monkeys);
            highMonkeys.add(highMonkey);
            monkeys.remove(highMonkey);
        }
        int result= 1;
        for(Monkey highMonkey : highMonkeys){
            result=result*highMonkey.inspectionCounter;
        }
        return result;
    }


    private static Monkey getHighestMonkey(List<Monkey> monkeys) {
        Monkey highMonkey=monkeys.get(0);
        for(Monkey monkey:monkeys){
            if(highMonkey.inspectionCounter<monkey.inspectionCounter)
                highMonkey=monkey;
        }
        return highMonkey;
    }

    private static Monkey createMonkey(ArrayDeque<String> currentMonkeySection) {
        String firstLine = currentMonkeySection.pollFirst();
        int name=Integer.parseInt(firstLine.replaceAll("[^\\p{IsDigit}]", ""));
        String itemsString = currentMonkeySection.pollFirst();
        String operationString = currentMonkeySection.pollFirst();
        int testDivisor = Integer.parseInt(currentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        int trueMonkey = Integer.parseInt(currentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        int falseMonkey = Integer.parseInt(currentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        Monkey monkey = new Monkey(name, operationString, testDivisor, trueMonkey, falseMonkey);

        String formatedItemString = itemsString.replaceAll("[^\\p{IsDigit},]", "");
        String[] items = formatedItemString.split(",");
        for(int currentItem = 0; currentItem<items.length; currentItem++){
            int worryLevel = Integer.parseInt(items[currentItem]);
            monkey.fetchItem(new Item(worryLevel, monkey.monkeyName));
        }
        return monkey;
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}