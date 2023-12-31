package com.rkostiuk.uconsole.command.parser.chain;

import com.rkostiuk.uconsole.command.CommandDetails;
import com.rkostiuk.uconsole.command.exception.UnknownCommandException;
import com.rkostiuk.uconsole.command.parser.CommandParser;

public abstract class CommandParserChain implements CommandParser {
    private CommandParserChain fallback;

    protected CommandDetails callFallbackIfPresentOrElseThrow(String command) {
        if (fallback != null) {
            return fallback.parse(command);
        }
        throw new UnknownCommandException("Unknown command: '" + command + "'");
    }

    public void setFallback(CommandParserChain fallback) {
        this.fallback = fallback;
    }
}
