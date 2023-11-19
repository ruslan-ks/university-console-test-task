package com.rkostiuk.uconsole.command.parser.chain.impl;

import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.parser.CommandParser;
import com.rkostiuk.uconsole.command.parser.chain.RegexBasedCommandParserChain;

import java.util.List;
import java.util.regex.Pattern;

public class HeadOfDepartmentCommandParser extends RegexBasedCommandParserChain {
    private static final Pattern PATTERN = Pattern.compile("Who is head of department\\s(.+)");
    private static final int DEPARTMENT_ARGUMENT_GROUP = 1;

    public HeadOfDepartmentCommandParser() {
    }

    public HeadOfDepartmentCommandParser(CommandParser next) {
        super(next);
    }

    @Override
    protected Pattern getCommandPattern() {
        return PATTERN;
    }

    @Override
    protected List<Integer> getArgumentGroups() {
        return List.of(DEPARTMENT_ARGUMENT_GROUP);
    }

    @Override
    protected CommandType getCommandType() {
        return CommandType.HEAD_OF_DEPARTMENT;
    }
}
