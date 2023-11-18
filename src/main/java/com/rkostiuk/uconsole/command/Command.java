package com.rkostiuk.uconsole.command;

public interface Command {
    CommandResult execute(Object... args);
}
