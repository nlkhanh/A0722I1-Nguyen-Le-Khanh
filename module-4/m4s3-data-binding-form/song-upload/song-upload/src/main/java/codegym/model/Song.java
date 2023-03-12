package codegym.model;

import java.util.List;

public class Song {
    private String name;
    private String author;
    private List<String> types;
    private String link;

    public Song() {
    }

    public Song(String name, String author, List<String> types, String link) {
        this.name = name;
        this.author = author;
        this.types = types;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
