package codegym.library.repository;

import codegym.library.entity.BorrowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowCardRepository extends JpaRepository<BorrowCard, String> {
    Page<BorrowCard> findAllByBorrowingIsTrue(Pageable pageable);

    @Query(value = "select * from borrow_cards bc inner join books b on bc.book_id = b.id inner join students s on bc.student_id = s.id where (bc.borrowing = true) and ((upper(b.name) like concat('%',upper(:book_name),'%')) and (upper(s.name) like concat('%',upper(:student_name),'%')))",
            countQuery = "select count(*) from borrow_cards bc inner join books b on bc.book_id = b.id inner join students s on bc.student_id = s.id where (bc.borrowing = true) and ((upper(b.name) like concat('%',upper(:book_name),'%')) and (upper(s.name) like concat('%',upper(:student_name),'%')))",
            nativeQuery = true)
    Page<BorrowCard> findAllByBorrowingSearch(Pageable pageable, @Param("book_name") String bookName, @Param("student_name") String studentName);

    boolean existsById(String id);
}