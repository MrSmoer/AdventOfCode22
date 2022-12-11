package Days.Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class Second {

    public static void main(String[] args) {

        long positionCount = 0;
        try {
             positionCount = solve(provideBufferedReader("src/Days/Day11/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day11/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static long solve(BufferedReader bufferedReader) {
        String line;
        List<IntelligentMonkey> monkeys = new ArrayList<>();
        ArrayDeque<String> lines = new ArrayDeque<String>();
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

            ArrayDeque<String> currentIntelligentMonkeySection = new ArrayDeque<>();
            long supermodulo = 1;
        for(String linen : lines){
            if(linen.equals("")){
                IntelligentMonkey monkey = createIntelligentMonkey(currentIntelligentMonkeySection);
                supermodulo=supermodulo*monkey.testDivisor;
                monkeys.add(monkey);
                currentIntelligentMonkeySection= new ArrayDeque<>();
            }else{
                currentIntelligentMonkeySection.add(linen);
            }
        }
        if(currentIntelligentMonkeySection.size()>0){
            IntelligentMonkey monkey = createIntelligentMonkey(currentIntelligentMonkeySection);
            supermodulo=supermodulo*monkey.testDivisor;
            monkeys.add(monkey);
        }
        for(IntelligentMonkey monkey:monkeys){
            monkey.setSupermodulo(supermodulo);
        }
        System.out.println();
        int rounds = 10000;
        for(int roundCounter = 1; roundCounter<rounds+1; roundCounter++){
            for(IntelligentMonkey currentIntelligentMonkey : monkeys){
                for(Item titem : currentIntelligentMonkey.items){
                    currentIntelligentMonkey.investigateFirstItem();
                    currentIntelligentMonkey.testWorryLevel();
                    currentIntelligentMonkey.throwItem();
                    monkeys.get(titem.monkeyDestination).fetchItem(titem);
                }
            }

            if(roundCounter==1){
                printCounter(monkeys,roundCounter);
            }
            if(roundCounter==20){
                printCounter(monkeys,roundCounter);
            }
            if(roundCounter%1000==0){
                printCounter(monkeys,roundCounter);
            }
            
        }
        int nHighestIntelligentMonkeys= 2;
        List<IntelligentMonkey> highIntelligentMonkeys = new ArrayList<>();
        for(int i = 0; i<nHighestIntelligentMonkeys; i++){
            IntelligentMonkey highIntelligentMonkey = getHighestIntelligentMonkey(monkeys);
            highIntelligentMonkeys.add(highIntelligentMonkey);
            monkeys.remove(highIntelligentMonkey);
        }
        long result= 1;
        for(IntelligentMonkey highIntelligentMonkey : highIntelligentMonkeys){
            result=result*highIntelligentMonkey.inspectionCounter;
        }
        return result;
    }


    private static void printCounter(List<IntelligentMonkey> monkeys, int roundCounter) {
        System.out.println("== After round "+roundCounter+" ==");
        for(IntelligentMonkey monkey : monkeys){
            System.out.println("Monkey "+monkey.monkeyName+" inspected items "+monkey.inspectionCounter+" times.");
        }

    }

    private static IntelligentMonkey getHighestIntelligentMonkey(List<IntelligentMonkey> monkeys) {
        IntelligentMonkey highIntelligentMonkey=monkeys.get(0);
        for(IntelligentMonkey monkey:monkeys){
            if(highIntelligentMonkey.inspectionCounter<monkey.inspectionCounter)
                highIntelligentMonkey=monkey;
        }
        return highIntelligentMonkey;
    }

    private static IntelligentMonkey createIntelligentMonkey(ArrayDeque<String> currentIntelligentMonkeySection) {
        String firstLine = currentIntelligentMonkeySection.pollFirst();
        int name=Integer.parseInt(firstLine.replaceAll("[^\\p{IsDigit}]", ""));
        String itemsString = currentIntelligentMonkeySection.pollFirst();
        String operationString = currentIntelligentMonkeySection.pollFirst();
        int testDivisor = Integer.parseInt(currentIntelligentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        int trueIntelligentMonkey = Integer.parseInt(currentIntelligentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        int falseIntelligentMonkey = Integer.parseInt(currentIntelligentMonkeySection.pollFirst().replaceAll("[^\\p{IsDigit}]", ""));
        IntelligentMonkey monkey = new IntelligentMonkey(name, operationString, testDivisor, trueIntelligentMonkey, falseIntelligentMonkey);

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

    public void printMonkeys(){

    }
}