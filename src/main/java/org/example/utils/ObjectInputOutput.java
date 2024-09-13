package org.example.utils;

import org.example.entities.CommitObject;

import java.io.*;
import java.util.Arrays;

public class ObjectInputOutput {

    public static void save( Object obj, String saveAtPath ) throws Throwable {
        try {
            FileOutputStream fileOut = new FileOutputStream(saveAtPath);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            objOut.close();
        }
        catch(IOException e){
            //TODO: We should log the actual stack trace somewhere
//            e.printStackTrace();
//            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new Throwable("There was some error encountered when trying to save the commit...\n" + e.getMessage());
        }
    }
    public static Object read (String objPath) throws Throwable {
        try {
            FileInputStream fileIn = new FileInputStream(objPath);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            return objIn.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            //TODO: We should log the actual stack trace somewhere
            throw new Throwable("There was some error encountered when trying to read the commit...\n" + e.getMessage());
        }
    }
}
