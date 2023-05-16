package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}