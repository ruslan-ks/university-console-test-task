package com.rkostiuk.uconsole.command.parser.chain.bulder;

import com.rkostiuk.uconsole.command.parser.chain.CommandParserChain;

public class CommandParserChainBuilderImpl implements CommandParserChainBuilder {
    private final CommandParserChain first;
    private CommandParserChain last;

    CommandParserChainBuilderImpl(CommandParserChain first) {
        this.first = first;
        this.last = first;
    }

    @Override
    public CommandParserChainBuilder then(CommandParserChain next) {
        last.setFallback(next);
        last = next;
        return this;
    }

    @Override
    public CommandParserChain build() {
        return first;
    }
}
