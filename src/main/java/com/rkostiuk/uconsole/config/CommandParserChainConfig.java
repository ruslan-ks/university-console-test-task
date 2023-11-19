package com.rkostiuk.uconsole.config;

import com.rkostiuk.uconsole.command.parser.CommandParser;
import com.rkostiuk.uconsole.command.parser.chain.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandParserChainConfig {

    @Bean
    public CommandParser commandParserChain() {
        CommandParser commandParserChain = new AverageDepartmentSalaryCommandParser();
        commandParserChain = new DepartmentEmployeeCountCommandParser(commandParserChain);
        commandParserChain = new DepartmentStatisticsCommandParser(commandParserChain);
        commandParserChain = new GlobalSearchCommandParser(commandParserChain);
        return new HeadOfDepartmentCommandParser(commandParserChain);
    }
}
