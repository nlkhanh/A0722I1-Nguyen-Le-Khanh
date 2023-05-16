package com.service.impl;

import com.entity.Project;
import com.repository.ProjectRepository;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Page<Project> findAllSearch(Pageable pageable, String search) {
        return null;
    }

    @Override
    public Project findById(Long id) {
        return null;
    }

    @Override
    public Project findById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Project> findAllSearch(Pageable pageable, LocalDate firstDate, LocalDate endDate, String projectName) {
        return projectRepository.findAllSearch(pageable, firstDate, endDate, projectName);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return projectRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
    }
}
