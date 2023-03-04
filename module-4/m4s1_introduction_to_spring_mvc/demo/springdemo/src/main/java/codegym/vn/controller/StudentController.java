package codegym.vn.controller;

import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/list")
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }
}
