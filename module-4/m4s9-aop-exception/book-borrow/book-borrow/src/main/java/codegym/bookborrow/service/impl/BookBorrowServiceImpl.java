package codegym.bookborrow.service.impl;

import codegym.bookborrow.model.BookBorrow;
import codegym.bookborrow.repository.BookBorrowRepository;
import codegym.bookborrow.service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowRepository bookBorrowRepository;

    @Override
    public BookBorrow findById(Long id) {
        return bookBorrowRepository.findById(id).orElse(new BookBorrow());
    }

    @Override
    public Boolean isExistBorrowCode(Integer code) {
        BookBorrow bookBorrow = bookBorrowRepository.findBookBorrowByBorrowCode(code).orElse(null);
        return bookBorrow != null;
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void delete(BookBorrow bookBorrow) {
        bookBorrowRepository.delete(bookBorrow);
    }

    @Override
    public BookBorrow findBookBorrowByBorrowCode(Integer code) {
        return bookBorrowRepository.findBookBorrowByBorrowCode(code).orElse(null);
    }
}
