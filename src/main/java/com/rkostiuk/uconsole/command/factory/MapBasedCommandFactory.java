package com.rkostiuk.uconsole.command.factory;

import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.Command;

import java.util.Map;
import java.util.NoSuchElementException;

public class MapBasedCommandFactory implements CommandFactory {
    private final Map<CommandType, Command> typeCommandMap;

    public MapBasedCommandFactory(Map<CommandType, Command> typeCommandMap) {
        this.typeCommandMap = typeCommandMap;
    }

    @Override
    public Command getCommand(CommandType type) {
        Command command = typeCommandMap.get(type);
        if (command == null) {
            throw new NoSuchElementException("Command for type " + type + " not found");
        }
        return command;
    }
}
