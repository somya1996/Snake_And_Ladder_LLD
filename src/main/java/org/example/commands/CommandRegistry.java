package org.example.commands;

import org.example.exceptions.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Map<String, ICommand> commands = new HashMap<>();

    public void registerCommand(String commandName , ICommand command)
    {
        commands.put(commandName , command);
    }

    public ICommand getCommand(String commandName){
        return commands.get(commandName);
    }
}