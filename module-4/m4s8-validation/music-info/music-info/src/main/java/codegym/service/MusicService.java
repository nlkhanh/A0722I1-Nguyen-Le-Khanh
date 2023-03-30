package codegym.service;

import codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MusicService {
    Page<Music> findAll(Pageable pageable);
    void save(Music music);
    Music findById(Long id);
}
