package codegym.service;

import codegym.model.Comment;

import java.util.List;

public interface PictureService {
    List<Comment> findAll();
    void save(Comment comment);
    void remove(Integer id);
    Comment findById(Integer id);
    void update(Comment comment);
    List<Comment> findToDay();
    void like(Integer id);
}
