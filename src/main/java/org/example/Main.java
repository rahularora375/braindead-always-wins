package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Please enter command !");
            return;
        }

        String command = args[0];

        if(!command.equals("commit")){
            System.out.printf("Expecting 'commit' got %s", command);
            return;
        }

        if(args.length < 2){
            System.out.println("Expecting file path got none");
            return;
        }

        String path = args[1];
        Path filePath = Path.of(path);

        if(!Files.exists(filePath)){
            System.out.println("Invalid path !");
            return;
        }

        List<String> fileContents = Files.readAllLines(filePath);
        CommitObject c1 = new CommitObject(1, "this is my first commit :)", fileContents);

        System.out.println(c1);
    }
}