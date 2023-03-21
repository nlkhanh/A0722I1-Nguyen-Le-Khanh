package codegym.service;

import codegym.model.Comment;
import codegym.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureRepository pictureRepository;


    @Override
    public List<Comment> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        pictureRepository.save(comment);
    }

    @Override
    public void remove(Integer id) {
        pictureRepository.remove(id);
    }

    @Override
    public Comment findById(Integer id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void update(Comment comment) {
        pictureRepository.update(comment);
    }

    @Override
    public List<Comment> findToDay() {
        return pictureRepository.findToDay();
    }

    @Override
    public void like(Integer id) {
        pictureRepository.like(id);
    }
}
