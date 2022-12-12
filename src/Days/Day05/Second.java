package Days.Day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        String[] zeilen = readLines("src/Days/Day05/input.txt");
        //String[] zeilen = readLines("src/Days/Day05/testInput.txt");
        int instructionBegin = getInstructionBeginIndex(zeilen);
        if (instructionBegin < 2 || instructionBegin >= zeilen.length - 1) {
            System.out.println("Could not find begin index (" + instructionBegin + ")");
            return;
        }
        int numberOfStacks = getStackCount(zeilen, instructionBegin);
        System.out.println(numberOfStacks + " Stacks");

        System.out.println("Reading Stacks");
        PortStorage pStorage = new PortStorage(numberOfStacks);
        for (int currentStack = 0; currentStack < numberOfStacks; currentStack++) {
            Deque<Character> stack = readStack(zeilen, currentStack, instructionBegin);
            pStorage.addStack(currentStack, stack);
        }

        System.out.println("Reading instructions");
        Deque<Instruction> instructions = new ArrayDeque<Instruction>();
        for (int intstructionCounter = 0; intstructionCounter < zeilen.length
                - instructionBegin-1; intstructionCounter++) {
            Instruction instruction = readInstruction(zeilen[intstructionCounter + instructionBegin]);
            instructions.add(instruction);
        }

        System.out.println("executing instructions");
        for (Instruction instruction : instructions) {
            Deque<Character> crateMover = new ArrayDeque<Character>();
            for (int boxCount = 0; boxCount < instruction.quantity; boxCount++) {
                //pStorage.moveItemFromStackToStack(instruction.sourceStack, instruction.targetStack);
                crateMover.add(pStorage.removeTopFromStack(instruction.sourceStack));
            }
            //System.out.println("tst");
            int initialSize=crateMover.size();
            for (int boxCount = 0; boxCount<initialSize; boxCount++){
                pStorage.addToStack(instruction.targetStack, crateMover.removeLast());
            }
        }
        System.out.println("Result: " + pStorage.getTopBoxes());
    }

    public static int getInstructionBeginIndex(String[] zeilen) {
        for (int beginIndex = 0; beginIndex < zeilen.length; beginIndex++) {
            if (zeilen[beginIndex].equals("")) {
                return beginIndex + 1;
            }
        }
        return -1;
    }

    public static int getStackCount(String[] zeilen, int instructionBegin) {
        String stackCountLine = zeilen[instructionBegin - 2];
        //int numberOfStacks = Integer.parseInt(stackCountLine.substring(stackCountLine.length() - 2)+"");
        int numberOfStacks = stackCountLine.split(" {1,}").length-1;
        return numberOfStacks;
    }

    public static Instruction readInstruction(String lineInstruction) {
        String[] words = lineInstruction.split(" ");
        return new Instruction(Integer.parseInt(words[1]), Integer.parseInt(words[3]), Integer.parseInt(words[5]));
    }

    public static Deque<Character> readStack(String[] zeilen, int currentStack, int instructionBegin) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int lineIndex = (currentStack) * 4 + 1;
        int firstBoxOnGround = instructionBegin - 3;
        for (int row = firstBoxOnGround; row >= 0; row--) {
            char charToAdd = zeilen[row].charAt(lineIndex);
            if (charToAdd == ' ')
                return stack;
            stack.add(charToAdd);
        }
        return stack;
    }

    public static String[] readLines(String filename) {
        try (FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            lines.add("");
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[1];
        }
    }
}