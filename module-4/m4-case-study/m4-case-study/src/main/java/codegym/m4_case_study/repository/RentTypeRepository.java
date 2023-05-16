package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentTypeRepository extends JpaRepository<RentType, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}