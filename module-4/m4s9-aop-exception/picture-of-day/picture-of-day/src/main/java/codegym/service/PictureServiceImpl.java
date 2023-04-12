package codegym.service;

import codegym.exception.BadWordFilterException;
import codegym.model.Comment;
import codegym.repository.PictureRepository;
import codegym.validation.CommentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private CommentValidate commentValidate;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return pictureRepository.findAll(pageable);
    }

    @Override
    public void save(Comment comment) throws BadWordFilterException {
        if (commentValidate.haveBadWords(comment)) {
            throw new BadWordFilterException(commentValidate.getBadWord());
        }
        pictureRepository.save(comment);
    }

    @Override
    public void remove(Integer id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public Comment findById(Integer id) {
        return pictureRepository.findById(id).orElse(new Comment());
    }

    @Override
    public Page<Comment> findByDate(Pageable pageable) {
        return pictureRepository.findByDate(LocalDate.now(), pageable);
    }
}
