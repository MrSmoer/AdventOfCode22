package Days.Day11;

import java.util.ArrayDeque;

public class Monkey {
    ArrayDeque<Item> items;
    Item itemUnderInvestigation;
    int monkeyName;
    String investigationOperation;
    int testDivisor;
    int trueMonkey;
    int falseMonkey;
    int inspectionCounter;

    public Monkey(int monkeyName, String investigationOperation, int testDivisor, int trueMonkey, int falseMonkey) {
        this.monkeyName = monkeyName;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.testDivisor = testDivisor;
        this.investigationOperation = investigationOperation;
        this.items = new ArrayDeque<Item>();
    }

    public void investigationOperation() {
        int worryLevel = this.itemUnderInvestigation.getWorryLevel();
        String replaced = this.investigationOperation.replaceAll("old", (worryLevel+""));
        String bare = replaced.replaceAll("[^\\p{IsDigit}+*]", "");
        int resultWorryLevel;
        if(bare.contains("*")){
            String[] numbers = bare.split("\\*");
            resultWorryLevel= Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
        } else if(bare.contains("+")){
            String[] numbers = bare.split("\\+");
            resultWorryLevel= Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
        } else {
            System.out.println("Operation went wrong");
            resultWorryLevel = 0;
        }
        this.itemUnderInvestigation.setWorryLevel(resultWorryLevel);
    }

    public void fetchItem(Item newItem) {
        this.items.add(newItem);
    }

    public void investigateFirstItem() {
        this.itemUnderInvestigation = this.items.pollFirst();
        this.investigationOperation();
        this.inspectionCounter++;
    }

    public void getBored() {
        int newWorryLevel = (int) this.itemUnderInvestigation.getWorryLevel() / 3;
        this.itemUnderInvestigation.setWorryLevel(newWorryLevel);
    }

    public boolean testWorryLevel() {
        int leftover= this.itemUnderInvestigation.getWorryLevel() % this.testDivisor;
        if (leftover==0){
            this.itemUnderInvestigation.setMonkeyDestination(this.trueMonkey);
            return true;
        }
        else{
            this.itemUnderInvestigation.setMonkeyDestination(this.falseMonkey);
            return false;
        }
    }

    public Item throwItem() {
        return this.itemUnderInvestigation;
    }
}
