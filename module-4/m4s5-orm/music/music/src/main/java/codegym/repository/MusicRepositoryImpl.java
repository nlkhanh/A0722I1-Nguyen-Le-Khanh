package codegym.repository;

import codegym.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements MusicRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select s from Song s").getResultList();
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void update(Song song) {
        entityManager.merge(song);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(findById(id));
    }
}
