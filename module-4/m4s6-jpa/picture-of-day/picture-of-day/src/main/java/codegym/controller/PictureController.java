package codegym.controller;

import codegym.model.Comment;
import codegym.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("evaluates", Arrays.asList(1, 2, 3, 4, 5));
        model.addAttribute("comments", pictureService.findToDay());
        return "index";
    }

    @PostMapping("/comment")
    public String save(Comment comment) {
        comment.setDate(LocalDate.now());
        pictureService.save(comment);
        return "redirect: /";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Integer id) {
        pictureService.like(id);
        return "redirect: /";
    }
}
