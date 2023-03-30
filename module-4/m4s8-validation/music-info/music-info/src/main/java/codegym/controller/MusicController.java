package codegym.controller;

import codegym.model.Music;
import codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;
    @GetMapping("")
    public String list(Model model,
                       @RequestParam("page")Optional<Integer> page,
                       @RequestParam("size")Optional<Integer> size,
                       @RequestParam("sort")Optional<String> sort
                       ) {
        int currPage = page.orElse(0);
        int pageSize = size.orElse(3);
        String sortField = sort.orElse("name");
        Pageable pageable = PageRequest.of(currPage, pageSize, Sort.by(sortField));
        Page<Music> musicPage = musicService.findAll(pageable);
        model.addAttribute("musicPage", musicPage);
        return "music/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("music", new Music());
        return "music/create";
    }

    @PostMapping ("/create")
    public String create(@Validated Music music, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("music", music);
            return "music/create";
        }
        musicService.save(music);
        attributes.addFlashAttribute("message", "New song recent add.");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "music/edit";
    }

    @PostMapping ("/update")
    public String update(@Validated Music music, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("music", music);
            return "music/edit";
        }
        musicService.save(music);
        attributes.addFlashAttribute("message", "A song recent edit.");
        return "redirect:/";
    }
}
