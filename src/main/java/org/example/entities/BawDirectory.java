package org.example.entities;

import java.util.HashMap;

public class BawDirectory {
    public String name;
    public HashMap<String, BawDirectory> subDirectories;
    public HashMap<String, BawFile> files;
}
