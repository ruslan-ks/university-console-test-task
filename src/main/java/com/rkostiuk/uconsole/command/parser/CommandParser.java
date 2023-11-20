package com.rkostiuk.uconsole.command.parser;

import com.rkostiuk.uconsole.command.CommandDetails;
import com.rkostiuk.uconsole.command.exception.UnknownCommandException;

public interface CommandParser {
    CommandDetails parse(String command) throws UnknownCommandException;
}
