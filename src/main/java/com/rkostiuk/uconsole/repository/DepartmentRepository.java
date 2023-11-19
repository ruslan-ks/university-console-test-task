package com.rkostiuk.uconsole.repository;

import com.rkostiuk.uconsole.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String departmentName);

    @Query("select avg(l.salary) from Department d left join d.lectors l where d.name = ?1")
    Optional<Double> findAverageSalary(String departmentName);

    @Query("select count(l) from Department d left join d.lectors l where d.name = ?1")
    Optional<Integer> countEmployees(String departmentName);
}
