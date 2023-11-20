package com.rkostiuk.uconsole.dto;

import com.rkostiuk.uconsole.entity.Lector;

public record DepartmentStatistics(Lector.Degree degree, long lectorCount) {
}
