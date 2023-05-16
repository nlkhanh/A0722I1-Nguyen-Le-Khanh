package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}