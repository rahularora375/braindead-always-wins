package org.example.commands;

import org.example.CommitObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Commit {
    private static final Integer startIdx = 1;
    public static String getName() {
        return "commit";
    }

    private static boolean validateArgs(String[] args) {
        Path filePath = Path.of(args[startIdx]);
        return Files.exists(filePath);
    }

    public static void execute(String[] args) throws Exception {
        if(!validateArgs(args))
            throw new Exception("Invalid Path or Path does not exist!");

        Path filePath = Path.of(args[startIdx]);
        List<String> fileContents = Files.readAllLines(filePath);

        //TODO: Read CommitHead in .baw and add CommitObject then update Head
//        CommitObject c1 = new CommitObject(1, "this is my first commit :)", fileContents);
    }
}