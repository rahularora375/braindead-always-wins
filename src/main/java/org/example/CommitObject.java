package org.example;

import java.io.*;
import java.util.List;

public class CommitObject implements Serializable {
    private String id;
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

    //TODO: Should we save in same class or create a separate class?
    public static void save( CommitObject obj) throws Throwable {
        try {
            FileOutputStream fileOut = new FileOutputStream(obj.getId());
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            objOut.close();
        }
        catch(IOException e){
            //TODO: We should log the actual stack trace somewhere
           throw new Throwable("There was some error encountered when trying to save the commit...");
        }
    }

    //TODO: Need to have better Exceptions instead of using Throwable everywhere xdd
    public static CommitObject read ( String id) throws Throwable {
        try {
            FileInputStream fileIn = new FileInputStream(id);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            return (CommitObject) objIn.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            //TODO: We should log the actual stack trace somewhere
            throw new Throwable("There was some error encountered when trying to read the commit...");
        }
    }
}