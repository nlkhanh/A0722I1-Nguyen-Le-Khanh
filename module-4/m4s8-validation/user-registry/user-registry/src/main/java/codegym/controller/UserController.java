package codegym.controller;

import codegym.model.User;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "views/index";
    }
    @PostMapping("/create")
    public String create(@Validated User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "views/index";
        }
        userService.save(user);
        model.addAttribute("user", user);
        return "views/result";
    }
}
