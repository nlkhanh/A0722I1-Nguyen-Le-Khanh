package codegym.service;

import codegym.model.Song;
import codegym.repository.SongUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongUploadServiceImpl implements SongUploadService {
    private static final List<String> FILE_EXTENSION = Arrays.asList(".mp3", ".wav", ".ogg", ".m4p");
    @Autowired
    private SongUploadRepository songUploadRepository;


    @Override
    public List<Song> findAll() {
        return songUploadRepository.findAll();
    }

    @Override
    public void upload(Song song) {
        songUploadRepository.upload(song);
    }

    @Override
    public boolean validateSong(String songName) {
        for (String extension : FILE_EXTENSION) {
            if (songName.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
