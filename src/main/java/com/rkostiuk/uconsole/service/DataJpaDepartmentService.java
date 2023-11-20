package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.dto.DepartmentStatistics;
import com.rkostiuk.uconsole.repository.DepartmentRepository;
import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataJpaDepartmentService implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DataJpaDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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
}
