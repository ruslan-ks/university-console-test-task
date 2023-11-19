package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;

public interface DepartmentService {
    double averageSalary(String departmentName) throws DepartmentNotFoundException;
    int countEmployees(String departmentName) throws DepartmentNotFoundException;
    String findHeadName(String departmentName) throws DepartmentNotFoundException;
}
