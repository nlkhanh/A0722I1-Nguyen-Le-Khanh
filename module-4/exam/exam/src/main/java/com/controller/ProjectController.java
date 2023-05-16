package com.controller;

import com.custom_validation.ProjectValidation;
import com.entity.Company;
import com.entity.Project;
import com.service.CompanyService;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ProjectValidation projectValidation;

    @GetMapping
    public String list(Model model,
                       @RequestParam("firstDateSearch") Optional<LocalDate> firstDateSearch,
                       @RequestParam("endDateSearch") Optional<LocalDate> endDateSearch,
                       @RequestParam("projectNameSearch") Optional<String> projectNameSearch,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        LocalDate firstDate = firstDateSearch.orElse(LocalDate.MIN);
        LocalDate endDate = endDateSearch.orElse(LocalDate.now());
        String projectName = projectNameSearch.orElse("");
        Page<Project> projects = projectService.findAllSearch(pageable, firstDate, endDate, projectName);
//        Page<Project> projects = projectService.findAll(pageable);
        model.addAttribute("projects", projects);
        model.addAttribute("firstDate", firstDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("projectName", projectName);
        return "projects/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Project project = new Project();
        project.setRegisterDate(LocalDate.now());
        project.setCompany(new Company());
        List<Company> companies = companyService.findAll();
        model.addAttribute("project", project);
        model.addAttribute("companies",companies);
        return "projects/create-and-update";
    }

    @PostMapping("/create")
    public String create(@Valid Project project, BindingResult result, Model model, RedirectAttributes attributes) {
        projectValidation.validate(project, result);
        if (result.hasErrors()) {
            List<Company> companies = companyService.findAll();
            model.addAttribute("project", project);
            model.addAttribute("companies",companies);
            return "projects/create-and-update";
        }
        project.setPrice(project.calPrice());
        projectService.save(project);
        attributes.addFlashAttribute("message", "New project has created");
        return "redirect:/projects";
    }
}
