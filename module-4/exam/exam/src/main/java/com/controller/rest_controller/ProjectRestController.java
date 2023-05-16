package com.controller.rest_controller;

import com.entity.Project;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProject(@RequestParam("id") String id) {
        Project project = projectService.findById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
