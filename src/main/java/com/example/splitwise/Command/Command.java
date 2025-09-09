package com.example.splitwise.Command;

public interface Command {
    boolean matches(String command);
    void execute(String command);
}
