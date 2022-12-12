package Days.Day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First {

    public static void main(String[] args) {

        int markerChars = 0;
        try {
            markerChars = solve(provideBufferedReader("src/Days/Day07/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(markerChars);
    }

    public static BufferedReader provideBufferedReader(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    public static int solve(BufferedReader bufferedReader) {
        int size = 0;
        try {
            List<Directory> allDirectories = new ArrayList<Directory>();
            List<Command> commands = new ArrayList<Command>();
            String line = null;
            System.out.println(bufferedReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (line.charAt(0) == '$') {
                    CommandType type;
                    String[] commandInput = line.substring(2).split(" ");
                    switch (commandInput[0]) {
                        case "cd":
                            type = CommandType.CD;
                            break;
                        case "ls":
                            type = CommandType.LS;
                            break;
                        default:
                            type = null;
                            System.out.println("Something is wrong");
                    }
                    // System.out.println("Imhere");
                    commands.add(new Command(type, commandInput));
                } else {
                    commands.get(commands.size() - 1).addOutputLine(line);
                }
            }
            bufferedReader.close();
            
            Directory root = new Directory();
            root.addObject("/", root);
            root.addObject("..", root);
            Directory workingDirectory = root;
            for (Command command : commands) {
                if (command.type == CommandType.CD) {
                    if (command.args[1].equals("a"))
                        System.out.println("Here we go!");
                    if (command.args[1].equals("/")){
                        workingDirectory=root;
                        continue;
                    }
                    Directory child = (Directory)workingDirectory.getChild(command.args[1]);
                    workingDirectory = (Directory)child;
                } else if (command.type == CommandType.LS) {
                    for(String outputLine : command.output){
                        String[] splitOutput = outputLine.split(" ");
                        if(splitOutput[0].equals("dir")){;
                            if(workingDirectory.getChild(splitOutput[1])!=null) // Directory has been seen before
                                continue;
                            //Add new directory to current dir
                            Directory foundDirectory = new Directory();
                            foundDirectory.addObject("..", workingDirectory);
                            workingDirectory.addObject(splitOutput[1], foundDirectory);
                            allDirectories.add(foundDirectory);

                        } else {
                            if(workingDirectory.getChild(splitOutput[1])!=null) // File has been seen before
                                continue;
                            //Add file to current dir
                            workingDirectory.addObject(splitOutput[1], new File(Integer.parseInt(splitOutput[0])));
                        }
                    }
                } else {
                    System.out.println("Wrong Command");
                    return 0;
                }
            }
            
            for (Directory directory : allDirectories){
                int directorySize=directory.getSize();
                if(directorySize>100000)
                    continue;
                else
                    size+=directorySize;
            }

            workingDirectory = root;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;

    }
}