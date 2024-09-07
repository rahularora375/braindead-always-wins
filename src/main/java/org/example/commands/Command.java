package org.example.commands;

public interface Command {
    public void validateArgs(String[] args) throws Exception;
    public Object execute() throws Exception;
    public String getName();
}