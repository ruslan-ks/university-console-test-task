package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;

public interface DepartmentService {
    double averageSalary(String departmentName) throws DepartmentNotFoundException;
}
