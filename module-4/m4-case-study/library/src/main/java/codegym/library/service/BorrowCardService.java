package codegym.library.service;

import codegym.library.entity.BorrowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface BorrowCardService {
    BorrowCard save(BorrowCard borrowCard);

    BorrowCard findById(String id);
    Page<BorrowCard> findAllBorrow(Pageable pageable);
    Page<BorrowCard> findAllBorrowSearch(Pageable pageable, String bookName, String studentName);
    boolean existsById(String id);
}
