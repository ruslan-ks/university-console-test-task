package com.rkostiuk.uconsole.command.parser.chain.bulder;

import com.rkostiuk.uconsole.command.parser.chain.CommandParserChain;

public interface CommandParserChainBuilder {
    /**
     * Add item to the chain
     * @param next next chain item
     * @return self
     */
    CommandParserChainBuilder then(CommandParserChain next);

    /**
     * @return build chain
     */
    CommandParserChain build();

    static CommandParserChainBuilder startChain(CommandParserChain first) {
        return new CommandParserChainBuilderImpl(first);
    }
}
