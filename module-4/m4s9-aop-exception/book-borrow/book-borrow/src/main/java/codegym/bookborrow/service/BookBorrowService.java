package codegym.bookborrow.service;

import codegym.bookborrow.model.BookBorrow;

public interface BookBorrowService {
    BookBorrow findById(Long id);
    Boolean isExistBorrowCode(Integer code);
    void save(BookBorrow bookBorrow);
    void delete(BookBorrow bookBorrow);
    BookBorrow findBookBorrowByBorrowCode(Integer code);
}
