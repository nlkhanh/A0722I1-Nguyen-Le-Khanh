package codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String name;
    private String author;
    private MultipartFile song;

    public SongForm() {
    }

    public SongForm(int id, String name, String author, MultipartFile song) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.song = song;
    }

    public SongForm(String name, String author, MultipartFile song) {
        this.name = name;
        this.author = author;
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }
}
