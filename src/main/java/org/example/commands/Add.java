package org.example.commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Add {

    private static final Integer startIdx = 1; //Starting index is 1 as index 0 will have the command name

    public static String getName() {
        return "add";
    }

    private static boolean validateArgs(String[] args) {
        Path filePath = Path.of(args[startIdx]);
        return Files.exists(filePath);
    }


    //TODO: This command should check if there are any changes for files in the provided path.
    // If yes, doing a commit should save all those changes.
    public static void execute(String[] args) throws Exception {
        if(!validateArgs(args))
            throw new Exception("Invalid Path or Path does not exist!");

        Path path = Path.of(args[startIdx]);
        if(Files.isDirectory(path)){
            //TODO: How to add directory and everything inside it
        }
        //TODO: How to add a single file


    }
}
