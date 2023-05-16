package codegym.jquery_animate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JqueryController {
    @GetMapping("/animate")
    public String animate() {
        return "animate";
    }

    @GetMapping("/hide-show")
    public String hideShow() {
        return "hide-show";
    }
}
