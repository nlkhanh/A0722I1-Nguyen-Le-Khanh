package com.repository;

import com.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query(value = "select p from Project p where (p.registerDate between :firstDate and :endDate) and upper(p.name) like concat('%',upper(:projectName),'%')",
            countQuery = "select count(p) from Project p where (p.registerDate between :firstDate and :endDate) and upper(p.name) like concat('%',upper(:projectName),'%')")
    public Page<Project> findAllSearch(Pageable pageable, LocalDate firstDate, LocalDate endDate, String projectName);
}