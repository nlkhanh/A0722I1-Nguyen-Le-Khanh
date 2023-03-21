package codegym.controller;

import codegym.model.Song;
import codegym.model.SongForm;
import codegym.service.MusicService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class MusicController {
    @Value("${song-upload}")
    private String songUpload;
    @Autowired
    private MusicService musicService;

    @GetMapping("")
    public String list(Model model) {
        List<Song> songs = musicService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "create";
    }

    @PostMapping("/save")
    public String save(SongForm songForm) {
        String songName = uploadSong(songForm);
        musicService.save(new Song(songForm.getName(), songForm.getAuthor(), songName));
        return "redirect: /";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Song song = musicService.findById(id);
        SongForm songForm = new SongForm(song.getId(), song.getName(), song.getAuthor(), null);
        model.addAttribute("songForm", songForm);
        return "edit";
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable("id") int id, HttpServletResponse response) {
        Song song = musicService.findById(id);
        try {
            File songFile = new File(songUpload + song.getFileName());
            byte[] data = FileUtils.readFileToByteArray(songFile);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + songFile.getName());
            response.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("songForm") SongForm songForm, Model model) {
        Song song = musicService.findById(songForm.getId());
        String songName = song.getFileName();
        if (songForm.getSong().getSize() > 0) {
            File oldSong = new File(songUpload + song.getFileName());
            oldSong.delete();
            songName = uploadSong(songForm);
        }
        musicService.update(new Song(songForm.getId(), songForm.getName(), songForm.getAuthor(), songName));
        return "redirect: /";
    }


    private String uploadSong(SongForm songForm) {
        MultipartFile songFile = songForm.getSong();
        String songName = songFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songFile.getBytes(), new File(songUpload + songName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return songName;
    }
}