package org.example.commands;

import org.example.entities.CommitHead;
import org.example.entities.CommitObject;
import org.example.utils.ObjectInputOutput;

import java.io.File;

public class Init {

    public final static String rootDir = ".baw";
    public static String getName() {
        return "init";
    }

    private static boolean validateArgs(String[] args) {
        return args.length == 1;
    }

    public static void execute(String[] args) throws Throwable {
        /* TODO:
            - Add sub-directory to store all commits in local
        */
        if(!validateArgs(args))
            throw new Exception("Unnecessary arguments provided!");

        File bawDir = new File(rootDir);
        if(bawDir.mkdir()) {
            System.out.println(".baw created");

            CommitHead head = new CommitHead("0");
            CommitHead.save(head);

            System.out.println("HEAD created");
            System.out.println("Initialization was successful");
        }
        else{
            System.out.println(".baw directory already exists!");
        }
    }
}
