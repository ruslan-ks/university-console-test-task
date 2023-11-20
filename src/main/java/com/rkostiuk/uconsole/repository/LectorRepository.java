package com.rkostiuk.uconsole.repository;

import com.rkostiuk.uconsole.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {
    @Query("select l.name from Lector l where l.name ilike ?1")
    List<String> findNamesLikeIgnoreCase(String lectorNamePattern);
}
