package com.rkostiuk.uconsole.command.parser;

import com.rkostiuk.uconsole.command.CommandParam;

public interface CommandParser {
    CommandParam parse(String command);
}
