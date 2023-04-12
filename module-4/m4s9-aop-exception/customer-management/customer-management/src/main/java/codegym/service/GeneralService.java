package codegym.service;

import codegym.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService<T> {
    Page<T> findAll(Pageable pageable);
    T findById(Long id) throws Exception;
    void save(T t) throws DuplicateEmailException;
    void delete(Long id);
}
