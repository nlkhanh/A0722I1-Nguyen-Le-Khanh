package codegym.controller;

import codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/login")
    public String index(@CookieValue(value = "userName", defaultValue = "") String userName, Model model) {
        Cookie cookie = new Cookie("userName", userName);
        model.addAttribute("cookieValue", cookie);
        return "index";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user,
                          Model model,
                          @CookieValue(value = "userName", defaultValue = "") String userName,
                          HttpServletResponse response) {
        if (user.getEmail() == null) user.setEmail("");
        if (user.getPassword() == null) user.setPassword("");
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            userName = user.getEmail();
            Cookie cookie = new Cookie("userName", userName);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login success. Welcome");
        } else {
            Cookie cookie = new Cookie("userName", userName);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "index";
    }
}
