package codegym.repository;

import codegym.model.Song;

import java.util.List;

public interface MusicRepository {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update (Song song);
    void remove(int id);
}
