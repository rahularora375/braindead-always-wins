package org.example.commands;

public class Init {
    public static String getName() {
        return "init";
    }

    private static boolean validateArgs(String[] args) {
        return args.length == 1;
    }

    public static void execute(String[] args){
        /* TODO: Create a .baw directory if not exists
        *  TODO: Initialize CommitHead to point null and save in .baw
        *  TODO: Add sub-directory to store all commits in local
        */
    }
}
