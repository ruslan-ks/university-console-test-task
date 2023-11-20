package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.dto.DepartmentStatistics;
import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    double averageSalary(String departmentName) throws DepartmentNotFoundException;
    int countEmployees(String departmentName) throws DepartmentNotFoundException;
    String findHeadName(String departmentName) throws DepartmentNotFoundException;
    List<DepartmentStatistics> getStatistics(String departmentName) throws DepartmentNotFoundException;
    List<String> findNamesContainingIgnoreCase(String string);
    List<String> globalNameSearch(String string);
}
