package codegym.controller;

import codegym.bean.EmailConfig;
import codegym.bean.EmailConfigForm;
import codegym.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/email-config")
public class EmailConfigController {
    @Autowired
    private EmailConfigService emailConfigService;

    @ModelAttribute("emailConfig")
    public EmailConfig getCurrentConfig() {
        return emailConfigService.find();
    }

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", Arrays.asList(5, 10, 15, 25, 50, 100));
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("emailConfig") EmailConfig emailConfig, Model model) {
        emailConfigService.update(emailConfig);
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", Arrays.asList(5, 10, 15, 25, 50, 100));
        return "index";
    }
}
