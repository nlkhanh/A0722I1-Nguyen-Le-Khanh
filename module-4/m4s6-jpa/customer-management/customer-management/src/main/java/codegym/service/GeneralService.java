package codegym.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
