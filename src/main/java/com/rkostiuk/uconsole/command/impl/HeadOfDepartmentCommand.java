package com.rkostiuk.uconsole.command.impl;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.service.DepartmentService;

import java.util.List;

public class HeadOfDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    public HeadOfDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CommandResult execute(Object... args) {
        var departmentName = (String) args[0];
        String headName = departmentService.findHeadName(departmentName);
        return new CommandResult("Head of %s department is %s", List.of(departmentName, headName));
    }
}
