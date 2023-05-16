package com.service;

import com.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ProjectService extends GeneralService<Project> {
    void delete(String id);
    boolean existsById(String id);
    Project findById(String id);
    Page<Project> findAllSearch(Pageable pageable, LocalDate firstDate, LocalDate endDate, String projectName);
}
