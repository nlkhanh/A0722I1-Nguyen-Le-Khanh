package codegym.bookborrow.service.impl;

import codegym.bookborrow.model.Book;
import codegym.bookborrow.repository.BookRepository;
import codegym.bookborrow.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
