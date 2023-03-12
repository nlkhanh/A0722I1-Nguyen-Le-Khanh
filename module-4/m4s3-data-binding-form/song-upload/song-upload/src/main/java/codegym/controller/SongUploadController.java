package codegym.controller;

import codegym.model.Song;
import codegym.model.SongForm;
import codegym.service.SongUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/song-upload")
public class SongUploadController {
    @Value("${song-upload}")
    private String songUpload;

    @Autowired
    private SongUploadService songUploadService;

    @GetMapping("")
    public String list(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("songs", songUploadService.findAll());
        model.addAttribute("message", message);
        return "list";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        model.addAttribute("types", Arrays.asList("Rock", "Ballard", "Rap", "R&B", "Bolero"));
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute("songForm") SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile songFile = songForm.getFile();
        String fileName  = songFile.getOriginalFilename();
        if (songUploadService.validateSong(fileName)) {
            try {
                FileCopyUtils.copy(songFile.getBytes(), new File(songUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Song song = new Song(songForm.getName(), songForm.getAuthor(), songForm.getTypes(), songUpload + fileName);
            songUploadService.upload(song);
            redirectAttributes.addFlashAttribute("message", "Song is uploaded!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Invalid song!");
        }
        return "redirect: /song-upload";
    }
}
