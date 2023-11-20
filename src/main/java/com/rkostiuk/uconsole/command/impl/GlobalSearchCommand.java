package com.rkostiuk.uconsole.command.impl;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.service.DepartmentService;

import java.util.List;

public class GlobalSearchCommand implements Command {
    private final DepartmentService departmentService;

    public GlobalSearchCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CommandResult execute(Object... args) {
        var search = (String) args[0];
        List<String> foundNames = departmentService.globalNameSearch(search);
        return new CommandResult(String.join(", ", foundNames), List.of(foundNames));
    }
}
