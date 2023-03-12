package codegym.repository;

import codegym.model.Song;

import java.util.List;

public interface SongUploadRepository {
    List<Song> findAll();
    void upload(Song song);
}
