package codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private String name;
    private String author;
    private List<String> types;
    private MultipartFile file;

    public SongForm() {
    }

    public SongForm(String name, String author, List<String> types, MultipartFile file) {
        this.name = name;
        this.author = author;
        this.types = types;
        this.file = file;
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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
