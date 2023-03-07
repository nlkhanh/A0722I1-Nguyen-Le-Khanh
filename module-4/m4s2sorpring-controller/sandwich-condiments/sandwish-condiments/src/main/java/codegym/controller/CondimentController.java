package codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {

    @GetMapping("/choose")
    public String displayChoose() {
        return "choose";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "list";
    }
}
