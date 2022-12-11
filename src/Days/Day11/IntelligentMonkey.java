package Days.Day11;

import java.util.ArrayDeque;

public class IntelligentMonkey {
    ArrayDeque<Item> items;
    Item itemUnderInvestigation;
    int monkeyName;
    String investigationOperation;
    long testDivisor;
    int trueMonkey;
    int falseMonkey;
    int inspectionCounter;
    long supermodulo;

    public IntelligentMonkey(int monkeyName, String investigationOperation, int testDivisor, int trueMonkey, int falseMonkey) {
        this.monkeyName = monkeyName;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.testDivisor = testDivisor;
        this.investigationOperation = investigationOperation;
        this.items = new ArrayDeque<Item>();
    }

    public void setSupermodulo(long supermodulo){
        this.supermodulo=supermodulo;
    }

    public void investigationOperation() {
        long worryLevel = this.itemUnderInvestigation.getWorryLevel();
        String replaced = this.investigationOperation.replaceAll("old", (worryLevel+""));
        String bare = replaced.replaceAll("[^\\p{IsDigit}+*]", "");
        long resultWorryLevel;
        if(bare.contains("*")){
            String[] numbers = bare.split("\\*");
            resultWorryLevel= (Long.parseLong(numbers[0])%this.supermodulo)*(Long.parseLong(numbers[1])%this.supermodulo);
        } else if(bare.contains("+")){
            String[] numbers = bare.split("\\+");
            resultWorryLevel= (Long.parseLong(numbers[0])%this.supermodulo)+(Long.parseLong(numbers[1])%this.supermodulo);
        } else {
            System.out.println("Operation went wrong");
            resultWorryLevel = 0;
        }
        /*if(resultWorryLevel>10000)
            System.out.println("Damn thats high");*/
        this.itemUnderInvestigation.setWorryLevel(resultWorryLevel%this.supermodulo);
    }

    public void fetchItem(Item newItem) {
        this.items.add(newItem);
    }

    public void investigateFirstItem() {
        this.itemUnderInvestigation = this.items.pollFirst();
        this.investigationOperation();
        this.inspectionCounter++;
    }


    public boolean testWorryLevel() {
        long leftover = this.itemUnderInvestigation.getWorryLevel() % this.testDivisor;
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
