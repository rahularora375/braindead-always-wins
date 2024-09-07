package org.example;

import java.util.List;

public class CommitObject {
    Integer id;
    String message;
    List<String> fileContent;
    CommitObject prevCommit;
    CommitObject nextCommit;

    public CommitObject(Integer id, String message, List<String> fileContent) {
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
}