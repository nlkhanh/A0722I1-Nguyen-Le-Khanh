package com.custom_validation;

import com.entity.Project;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectValidation implements Validator {
    @Autowired
    private ProjectService projectService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Project.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Project project = new Project();
        if (target instanceof Project) {
            project = (Project) target;
        }

        String id = project.getId();

        ValidationUtils.rejectIfEmpty(errors, "id", "empty.projectId");

        if (!id.matches("DA-[0-9]{4}")) {
            errors.rejectValue("id", "regex.projectId");
        } else if (projectService.existsById(id)) {
            errors.rejectValue("id", "exists.projectId");
        }
    }
}
