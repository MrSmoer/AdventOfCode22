package Days.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import Days.Day10.Instructions.Instruction;
import Days.Day10.Instructions.addxInstruction;
import Days.Day10.Instructions.noopInstruction;

public class Second {

    public static void main(String[] args) {

        int positionCount = 0;
        try {
            positionCount = solve(provideBufferedReader("src/Days/Day10/input.txt"));
            // positionCount = solve(provideBufferedReader("src/Days/Day10/testInput.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(positionCount);
    }

    public static int solve(BufferedReader bufferedReader) {
        List<Class<? extends Instruction>> allInstructions = new ArrayList<Class<? extends Instruction>>();
        allInstructions.add(addxInstruction.class);
        allInstructions.add(noopInstruction.class);

        ConcurrentHashMap<String, Class<? extends Instruction>> instructionMap = new ConcurrentHashMap<String, Class<? extends Instruction>>();
        for (Class<? extends Instruction> instructionClass : allInstructions) {
            try {
                Class<?>[] parameterType = new Class[1];
                parameterType[0] = String.class;
                instructionMap.put(
                        instructionClass.getDeclaredConstructor(parameterType).newInstance(" ").getInstructionName(),
                        instructionClass);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
        }
        Deque<Instruction> instructionDeque = new ArrayDeque<>();
        String line;
        Class<?>[] parameterType = new Class[1];
        parameterType[0] = String.class;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                Instruction newInstruction = instructionMap.get(words[0]).getDeclaredConstructor(parameterType)
                        .newInstance(line);
                instructionDeque.add(newInstruction);

            }
        } catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        Cpu cpu = new Cpu(instructionDeque);
        int cycleCounter = 0;
        while (cycleCounter < 40) {
            if (!cpu.cycle())
                break;
            cycleCounter++;
        }
        int nextMeasurement = 80;
        while (cpu.hasNewInstruction()) {
            while (cycleCounter < nextMeasurement) {
                if (!cpu.cycle())
                    break;
                cycleCounter++;
            }
            nextMeasurement = nextMeasurement + 40;
            
        }
        cpu.crt.addLastLine();
        cpu.crt.printScreen();


        return 0;
    }


    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
}