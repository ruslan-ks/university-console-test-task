package com.rkostiuk.uconsole.repository;

import com.rkostiuk.uconsole.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("from Department d left join fetch d.lectors")
    List<Department> findAllFetchLectors();

    @Query("select avg(l.salary) from Department d left join d.lectors l where d.name = ?1")
    double findAverageSalary(String departmentName);
}
