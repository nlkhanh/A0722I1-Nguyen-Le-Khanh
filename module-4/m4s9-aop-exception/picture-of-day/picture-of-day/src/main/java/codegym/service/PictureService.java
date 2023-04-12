package codegym.service;

import codegym.exception.BadWordFilterException;
import codegym.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PictureService {
    Page<Comment> findAll(Pageable pageable);
    void save(Comment comment) throws BadWordFilterException;
    void remove(Integer id);
    Comment findById(Integer id);
    Page<Comment> findByDate(Pageable pageable);
}
