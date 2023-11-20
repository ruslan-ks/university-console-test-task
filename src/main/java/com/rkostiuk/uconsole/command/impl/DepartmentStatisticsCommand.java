package com.rkostiuk.uconsole.command.impl;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.dto.DepartmentStatistics;
import com.rkostiuk.uconsole.entity.Lector;
import com.rkostiuk.uconsole.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentStatisticsCommand implements Command {
    private static final String RESULT_TEMPLATE = "assistants - %d\nassociate professors - %d\nprofessors - %d";

    private final DepartmentService departmentService;

    public DepartmentStatisticsCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public CommandResult execute(Object... args) {
        var departmentName = (String) args[0];
        List<DepartmentStatistics> statistics = departmentService.getStatistics(departmentName);
        List<Object> resultValues = getStatisticsOrDefaultsInTemplateOrder(statistics);
        return new CommandResult(RESULT_TEMPLATE, resultValues);
    }

    private static List<Object> getStatisticsOrDefaultsInTemplateOrder(List<DepartmentStatistics> statistics) {
        Map<Lector.Degree, Long> degreeLectorCountMap = statistics.stream()
                .collect(Collectors.toMap(DepartmentStatistics::degree, DepartmentStatistics::lectorCount));
        return List.of(
                degreeLectorCountMap.getOrDefault(Lector.Degree.ASSISTANT, 0L),
                degreeLectorCountMap.getOrDefault(Lector.Degree.ASSOCIATE_PROFESSOR, 0L),
                degreeLectorCountMap.getOrDefault(Lector.Degree.PROFESSOR, 0L)
        );
    }
}
