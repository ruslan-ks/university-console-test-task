package com.rkostiuk.uconsole.config;

import com.rkostiuk.uconsole.command.AverageDepartmentSalaryCommand;
import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandType;
import com.rkostiuk.uconsole.command.factory.CommandFactory;
import com.rkostiuk.uconsole.command.factory.MapBasedCommandFactory;
import com.rkostiuk.uconsole.service.DepartmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CommandFactoryConfig {

    @Bean
    public CommandFactory commandFactory(DepartmentService departmentService) {
        Map<CommandType, Command> commandMap = Map.of(
                CommandType.AVERAGE_DEPARTMENT_SALARY, new AverageDepartmentSalaryCommand(departmentService)
        );
        return new MapBasedCommandFactory(commandMap);
    }
}
