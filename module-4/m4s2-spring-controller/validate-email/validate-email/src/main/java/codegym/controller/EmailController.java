package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isValid = validate(email);
        if (!isValid) {
            model.addAttribute("email", email);
            model.addAttribute("message", "Email is invalid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
