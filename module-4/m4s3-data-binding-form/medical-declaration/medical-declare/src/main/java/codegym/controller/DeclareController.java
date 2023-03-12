package codegym.controller;

import codegym.com.Common;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeclareController {

    @GetMapping("/declare")
    public String getDeclare(Model model) {

        model.addAttribute("years", Common.getYears());
        return "declare";
    }
}
