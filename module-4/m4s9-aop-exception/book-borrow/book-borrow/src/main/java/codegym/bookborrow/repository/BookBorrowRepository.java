package codegym.bookborrow.repository;

import codegym.bookborrow.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
    Optional<BookBorrow> findBookBorrowByBorrowCode(Integer code);
}
