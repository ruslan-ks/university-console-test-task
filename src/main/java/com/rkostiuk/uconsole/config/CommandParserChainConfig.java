package com.rkostiuk.uconsole.config;

import com.rkostiuk.uconsole.command.parser.CommandParser;
import com.rkostiuk.uconsole.command.parser.chain.bulder.CommandParserChainBuilder;
import com.rkostiuk.uconsole.command.parser.chain.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandParserChainConfig {

    @Bean
    public CommandParser commandParserChain() {
        return CommandParserChainBuilder
                .startChain(new AverageDepartmentSalaryCommandParser())
                .then(new DepartmentEmployeeCountCommandParser())
                .then(new DepartmentStatisticsCommandParser())
                .then(new GlobalSearchCommandParser())
                .then(new HeadOfDepartmentCommandParser())
                .build();
    }
}
