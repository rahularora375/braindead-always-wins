package org.example;

import org.example.commands.Add;
import org.example.commands.Commit;
import org.example.commands.Init;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Please enter some command !");
            return;
        }

        try {
            runBawCommand(args);
        }
        catch (Throwable e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void runBawCommand(String[] args) throws Throwable {
        String cmd = args[0];
        //TODO: Each command or action should save some kind of log. Later we can use it for git log.
        //TODO: Maybe only allow other commands if baw has been initialized?
        switch (cmd) {
            case "init":
                Init.execute(args); break;
            case "commit":
                Commit.execute(args); break;
            case "add":
                Add.execute(args); break;

            default: throw new Exception("Command name is unknown!");
        }
    }
}