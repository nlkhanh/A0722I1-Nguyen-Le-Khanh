package codegym.blogapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService<T> {
    Page<T> findAll(Pageable pageable);
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
