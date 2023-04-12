package codegym.bookborrow.service;

import codegym.bookborrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(Long id);
    void save(Book book);
}
