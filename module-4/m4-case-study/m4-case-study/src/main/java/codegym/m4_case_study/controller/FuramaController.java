package codegym.m4_case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {
    @GetMapping
    private String index() {
        return "furama-resort/home/home";
    }
}
