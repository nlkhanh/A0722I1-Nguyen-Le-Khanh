package codegym.repository;

import codegym.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("select b from Blog b").getResultList();
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
