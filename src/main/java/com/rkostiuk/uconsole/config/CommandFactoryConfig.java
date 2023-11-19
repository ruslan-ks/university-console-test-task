package com.rkostiuk.uconsole.config;

import com.rkostiuk.uconsole.command.impl.AverageDepartmentSalaryCommand;
import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.factory.CommandFactory;
import com.rkostiuk.uconsole.command.factory.MapBasedCommandFactory;
import com.rkostiuk.uconsole.command.impl.DepartmentEmployeeCountCommand;
import com.rkostiuk.uconsole.command.impl.HeadOfDepartmentCommand;
import com.rkostiuk.uconsole.service.DepartmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static com.rkostiuk.uconsole.command.CommandType.*;

@Configuration
public class CommandFactoryConfig {

    @Bean
    public CommandFactory commandFactory(DepartmentService departmentService) {
        Map<CommandType, Command> commandMap = Map.of(
                AVERAGE_DEPARTMENT_SALARY, new AverageDepartmentSalaryCommand(departmentService),
                DEPARTMENT_EMPLOYEE_COUNT, new DepartmentEmployeeCountCommand(departmentService),
                HEAD_OF_DEPARTMENT, new HeadOfDepartmentCommand(departmentService)
        );
        return new MapBasedCommandFactory(commandMap);
    }
}
