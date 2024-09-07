package org.example.commands;

import org.example.CommitObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Commit {

    public static String getName() {
        return "commit";
    }

    private static boolean validateArgs(String[] args) {
        Path filePath = Path.of(args[0]);
        return Files.exists(filePath);
    }

    public static CommitObject execute(String[] args) throws Exception {
        if(validateArgs(args)){
            Path filePath = Path.of(args[0]);
            List<String> fileContents = Files.readAllLines(filePath);
            return new CommitObject(1, "this is my first commit :)", fileContents);
        } else throw new Exception("Invalid Path !");
    }
}