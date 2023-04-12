package codegym.repository;

import codegym.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
public interface PictureRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findByDate(LocalDate localDate, Pageable pageable);
}
