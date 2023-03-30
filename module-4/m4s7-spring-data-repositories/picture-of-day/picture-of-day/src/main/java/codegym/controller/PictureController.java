package codegym.controller;

import codegym.model.Comment;
import codegym.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam("likeId") Optional<Integer> likeId,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size,
                        @RequestParam("sort") Optional<String> sort) {
        if (likeId.isPresent()) {
            Comment comment = pictureService.findById(likeId.get());
            comment.setLikes(comment.getLikes() + 1);
            pictureService.save(comment);
        }
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        model.addAttribute("comment", new Comment());
        model.addAttribute("evaluates", Arrays.asList(1, 2, 3, 4, 5));
        model.addAttribute("comments", pictureService.findByDate(pageable));
        return "index";
    }

    @PostMapping("/comment")
    public String save(Comment comment) {
        comment.setDate(LocalDate.now());
        pictureService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like")
    public String like(@RequestParam("likeId") Integer likeId,
                       @RequestParam("page") Integer page) {
        Comment comment = pictureService.findById(likeId);
        comment.setLikes(comment.getLikes() + 1);
        pictureService.save(comment);
        return "redirect:/?page=" + page;
    }
}
