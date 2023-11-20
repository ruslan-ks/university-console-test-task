package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.dto.DepartmentStatistics;
import com.rkostiuk.uconsole.repository.DepartmentRepository;
import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DataJpaDepartmentService implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final LectorService lectorService;

    public DataJpaDepartmentService(DepartmentRepository departmentRepository, LectorService lectorService) {
        this.departmentRepository = departmentRepository;
        this.lectorService = lectorService;
    }

    @Override
    public double averageSalary(String departmentName) throws DepartmentNotFoundException {
        throwIfNotFound(departmentName);
        return departmentRepository.findAverageSalary(departmentName).orElse(.0);
    }

    @Override
    public int countEmployees(String departmentName) throws DepartmentNotFoundException {
        throwIfNotFound(departmentName);
        return departmentRepository.countEmployees(departmentName).orElse(0);
    }

    @Override
    public String findHeadName(String departmentName) throws DepartmentNotFoundException {
        throwIfNotFound(departmentName);
        return departmentRepository.findHeadName(departmentName);
    }

    @Override
    public List<DepartmentStatistics> getStatistics(String departmentName) throws DepartmentNotFoundException {
        throwIfNotFound(departmentName);
        return departmentRepository.getStatistics(departmentName);
    }

    private void throwIfNotFound(String departmentName) {
        if (!departmentRepository.existsByName(departmentName)) {
            throw new DepartmentNotFoundException("Department '" + departmentName + "' not found");
        }
    }

    @Override
    public List<String> findNamesContainingIgnoreCase(String string) {
        return departmentRepository.findNamesLikeIgnoreCase('%' + string + '%');
    }

    @Override
    public List<String> globalNameSearch(String string) {
        List<String> foundLectors = lectorService.findNamesContainingIgnoreCase(string);
        List<String> foundDepartments = findNamesContainingIgnoreCase(string);

        return Stream.concat(foundDepartments.stream(), foundLectors.stream()).toList();
    }
}
