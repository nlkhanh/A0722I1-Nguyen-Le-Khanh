package codegym.service;

import codegym.model.Music;
import codegym.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MusicServiceImpl implements MusicService{
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id).orElse(new Music());
    }
}
