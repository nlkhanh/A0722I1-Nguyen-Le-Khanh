package com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    Page<T> findAllSearch(Pageable pageable, String search);
    T findById(Long id);
    T save(T t);
    void delete(Long id);
}

