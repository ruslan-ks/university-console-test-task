package com.rkostiuk.uconsole.command.parser.chain.impl;

import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.parser.chain.RegexBasedCommandParserChain;

import java.util.List;
import java.util.regex.Pattern;

public class GlobalSearchCommandParser extends RegexBasedCommandParserChain {
    private static final Pattern PATTERN = Pattern.compile("Global search by (.+)");
    private static final int SEARCH_ARGUMENT_GROUP = 1;

    @Override
    protected Pattern getCommandPattern() {
        return PATTERN;
    }

    @Override
    protected List<Integer> getArgumentGroups() {
        return List.of(SEARCH_ARGUMENT_GROUP);
    }

    @Override
    protected CommandType getCommandType() {
        return CommandType.GLOBAL_SEARCH;
    }
}
