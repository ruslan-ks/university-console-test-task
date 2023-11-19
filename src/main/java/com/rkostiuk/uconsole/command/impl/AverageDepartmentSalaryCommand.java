package com.rkostiuk.uconsole.command.impl;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.service.DepartmentService;

import java.util.List;

public class AverageDepartmentSalaryCommand implements Command {
    private final DepartmentService departmentService;

    public AverageDepartmentSalaryCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CommandResult execute(Object... args) {
        var departmentName = (String) args[0];
        double averageSalary = departmentService.averageSalary(departmentName);
        String resultPattern = "The average salary of %s is %f";
        return new CommandResult(resultPattern, List.of(departmentName, averageSalary));
    }
}
