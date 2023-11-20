package com.rkostiuk.uconsole.repository;

import com.rkostiuk.uconsole.dto.DepartmentStatistics;
import com.rkostiuk.uconsole.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String departmentName);

    @Query("select avg(l.salary) from Department d join d.lectors l where d.name = ?1")
    Optional<Double> findAverageSalary(String departmentName);

    @Query("select count(l) from Department d join d.lectors l where d.name = ?1")
    Optional<Integer> countEmployees(String departmentName);

    @Query("select d.head.name from Department d where d.name = ?1")
    String findHeadName(String departmentName);

    @Query("""
            select new com.rkostiuk.uconsole.dto.DepartmentStatistics(l.degree, count(l))
            from Department d
            join d.lectors l
            where d.name = ?1
            group by l.degree
            """)
    List<DepartmentStatistics> getStatistics(String departmentName);

    @Query("select d.name from Department d where d.name ilike ?1")
    List<String> findNamesLikeIgnoreCase(String departmentNamePattern);
}
