package com.rkostiuk.uconsole.command.parser;

import com.rkostiuk.uconsole.command.CommandDetails;

public interface CommandParser {
    CommandDetails parse(String command);
}
