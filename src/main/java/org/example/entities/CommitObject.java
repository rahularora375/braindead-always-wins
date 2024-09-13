package org.example.entities;

import org.example.utils.ObjectInputOutput;

import java.io.*;
import java.util.List;

public class CommitObject implements Serializable {
    private final String id;
    public final static String rootDir = ".baw/";
    String message;

    //TODO: This need not be single file right? How can we save multiple files with possible different directory structures?
    List<String> fileContent;
    String prevCommit;
    String nextCommit;

    public String getId(){
        return this.id;
    }
    public CommitObject(String id, String message, List<String> fileContent) {
        this.id = id;
        this.message = message;
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "id: "+id+"\n"+
               "message: "+message+"\n"+
               "fileContent: "+fileContent;
    }

    //TODO: Maybe this save should not be static?
    public static void save( CommitObject obj) throws Throwable {
            String filePath = rootDir + obj.getId() +".ser";
            ObjectInputOutput.save(obj, filePath);
    }

    public static CommitObject read ( String id) throws Throwable {
            String filePath = rootDir + id +".ser";
            return (CommitObject) ObjectInputOutput.read(filePath);
    }
}