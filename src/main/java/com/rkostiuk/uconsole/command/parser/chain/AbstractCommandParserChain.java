package com.rkostiuk.uconsole.command.parser.chain;

import com.rkostiuk.uconsole.command.CommandParam;
import com.rkostiuk.uconsole.command.exception.UnknownCommandException;
import com.rkostiuk.uconsole.command.parser.CommandParser;

public abstract class AbstractCommandParserChain implements CommandParser {
    private CommandParser fallback;

    protected AbstractCommandParserChain() {
    }

    protected AbstractCommandParserChain(CommandParser fallback) {
        this.fallback = fallback;
    }

    protected CommandParam callFallbackIfPresentOrElseThrow(String command) {
        if (fallback != null) {
            return fallback.parse(command);
        }
        throw new UnknownCommandException("Unknown command: '" + command + "'");
    }
}
