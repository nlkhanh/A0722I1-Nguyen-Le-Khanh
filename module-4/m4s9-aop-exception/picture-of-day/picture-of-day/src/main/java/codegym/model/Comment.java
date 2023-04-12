package codegym.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer evaluate;
    private String author;
    private String feedBack;
    private LocalDate date;
    private Long likes = 0L;

    public Comment() {
    }

    public Comment(Integer evaluate, String author, String feedBack, LocalDate date, Long likes) {
        this.evaluate = evaluate;
        this.author = author;
        this.feedBack = feedBack;
        this.date = date;
        this.likes = likes;
    }

    public Comment(Integer id, Integer evaluate, String author, String feedBack, LocalDate date, Long likes) {
        this.id = id;
        this.evaluate = evaluate;
        this.author = author;
        this.feedBack = feedBack;
        this.date = date;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Author='" + author + '\'' +
                ", feedBack='" + feedBack + '\'' +
                ", date=" + date;
    }
}
