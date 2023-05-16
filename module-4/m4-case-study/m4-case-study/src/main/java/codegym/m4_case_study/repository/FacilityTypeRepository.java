package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}