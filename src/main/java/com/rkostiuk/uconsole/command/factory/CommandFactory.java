package com.rkostiuk.uconsole.command.factory;

import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.Command;

public interface CommandFactory {
    Command getCommand(CommandType type);
}
