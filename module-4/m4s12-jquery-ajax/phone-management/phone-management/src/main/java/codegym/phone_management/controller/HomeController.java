package codegym.phone_management.controller;

import codegym.phone_management.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phones")
public class HomeController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public String showIndex() {
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("phone", phoneService.findById(id));
        return "edit";
    }
}
