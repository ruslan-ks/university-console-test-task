package com.rkostiuk.uconsole.command.impl;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.service.DepartmentService;

import java.util.List;

public class DepartmentEmployeeCountCommand implements Command {
    private final DepartmentService departmentService;

    public DepartmentEmployeeCountCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CommandResult execute(Object... args) {
        var departmentName = (String) args[0];
        int employeeCount = departmentService.countEmployees(departmentName);
        return new CommandResult("%d", List.of(employeeCount));
    }
}
