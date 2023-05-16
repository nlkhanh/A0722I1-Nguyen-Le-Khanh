package codegym.repository;

import codegym.entity.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BorrowCardRepository extends JpaRepository<BorrowCard, String> {
    boolean existsById(String id);
    @Query(value = "select bc from BorrowCard bc where bc.borrowing=true and upper(bc.book.name) like concat('%',upper(:bookName),'%') and upper(bc.student.name) like concat('%',upper(:studentName),'%')")
    List<BorrowCard> findAllSearch(@Param("bookName") String bookName, @Param("studentName") String studentName);
}