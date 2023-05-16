package codegym.m4_case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<T> {
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    T findById(Long id);
    T save (T t);
    void deleteById(Long id);
    void delete(List<Long> deleteIds);
}
