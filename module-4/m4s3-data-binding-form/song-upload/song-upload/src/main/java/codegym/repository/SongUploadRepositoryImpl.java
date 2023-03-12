package codegym.repository;

import codegym.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongUploadRepositoryImpl implements SongUploadRepository{
    private static List<Song> songs;

    static {
        songs = new ArrayList<>();
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void upload(Song song) {
        songs.add(song);
    }
}
