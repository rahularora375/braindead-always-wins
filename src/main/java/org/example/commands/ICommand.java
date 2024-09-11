package org.example.commands;

//TODO: Should the name be ICommand or Command?? What is difference man?
public interface ICommand {
    public void validateArgs(String[] args) throws Exception;
    public Object execute() throws Exception;
    public String getName();
}