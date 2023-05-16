package codegym.m4_case_study.controller;

import codegym.m4_case_study.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/furama-resort/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String list(Model model,
                       @RequestParam("search") Optional<String> search,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        model.addAttribute("employees", employeeService.findAllSearch(searchValue, pageable));
        model.addAttribute("search", searchValue);
        return "furama-resort/employee/list";
    }
}
