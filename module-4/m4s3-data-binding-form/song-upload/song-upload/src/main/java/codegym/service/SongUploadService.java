package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface SongUploadService {
    List<Song> findAll();
    void upload(Song song);
    boolean validateSong(String songName);
}
