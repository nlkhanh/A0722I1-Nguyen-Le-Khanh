package codegym.service;

import codegym.model.Song;
import codegym.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{
     @Autowired
    MusicRepository musicRepository;

    @Override
    public List<Song> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        musicRepository.save(song);
    }

    @Override
    public void update(Song song) {
        musicRepository.update(song);
    }

    @Override
    public void remove(int id) {
        musicRepository.remove(id);
    }
}
