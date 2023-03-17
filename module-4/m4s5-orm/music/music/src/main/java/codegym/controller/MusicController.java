package codegym.controller;

import codegym.model.Song;
import codegym.model.SongForm;
import codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Value("${song-upload}")
    private String songUpload;
    @Autowired
    private MusicService musicService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("songForm") SongForm songForm) {
        MultipartFile songFile = songForm.getSong();
        String songName = songFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songFile.getBytes(), new File(songUpload + songName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        musicService.save(new Song(songForm.getName(), songForm.getAuthor(), songUpload + songName));
        return "redirect: /create";
    }
}
