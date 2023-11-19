package com.rkostiuk.uconsole.command.parser.chain.impl;

import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.parser.CommandParser;
import com.rkostiuk.uconsole.command.parser.chain.RegexBasedCommandParserChain;

import java.util.List;
import java.util.regex.Pattern;

public class AverageDepartmentSalaryCommandParser extends RegexBasedCommandParserChain {

    private static final Pattern PATTERN = Pattern.compile("Show the average salary for the department\\s(.+)");
    private static final int DEPARTMENT_ARGUMENT_GROUP = 1;

    public AverageDepartmentSalaryCommandParser() {
    }

    public AverageDepartmentSalaryCommandParser(CommandParser next) {
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
        return CommandType.AVERAGE_DEPARTMENT_SALARY;
    }
}
