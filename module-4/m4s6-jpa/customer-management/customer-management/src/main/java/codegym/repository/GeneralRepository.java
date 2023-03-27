package codegym.repository;

import java.util.List;

public interface GeneralRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
