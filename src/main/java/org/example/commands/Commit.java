package org.example.commands;

import org.example.entities.CommitHead;
import org.example.entities.CommitObject;
import org.example.utils.ObjectInputOutput;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Commit implements ICommand{
    private static final Integer startIdx = 1; //Starting index is 1 as index 0 will have the command name

    public static String getName() {
        return "commit";
    }

    private static boolean validateArgs(String[] args) {
        Path filePath = Path.of(args[startIdx]);
        return Files.exists(filePath);
    }

    public static void execute(String[] args) throws Throwable {
        if(!validateArgs(args))
            throw new Exception("Invalid Path or Path does not exist!");

        Path filePath = Path.of(args[startIdx]);
        List<String> fileContents = Files.readAllLines(filePath);

        //TODO: Unique ID should be generated automatically, and message be picked from args
        CommitObject commitObj = new CommitObject("1", "Test commit", fileContents);
        CommitObject.save(commitObj);

        CommitHead head = CommitHead.read();
        head.updateAndSave(commitObj);
    }
}