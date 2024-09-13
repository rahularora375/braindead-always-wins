package org.example.entities;

import org.example.utils.ObjectInputOutput;

import java.io.Serializable;

public class CommitHead implements Serializable {
    public String id;
    public final static String rootDir = ".baw/";
    public CommitHead(String id){
        this.id = id;
    }

    public void updateAndSave(CommitObject obj) throws Throwable {
        this.id = obj.getId();
        save(this);
    }

    public static void save( CommitHead obj) throws Throwable {
        String filePath = rootDir + "HEAD.ser";
        ObjectInputOutput.save(obj, filePath);
    }

    public static CommitHead read () throws Throwable {
        String filePath = rootDir + "HEAD.ser";
        return (CommitHead) ObjectInputOutput.read(filePath);
    }

}
