package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface MusicService {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update (Song song);
    void remove(int id);
}
