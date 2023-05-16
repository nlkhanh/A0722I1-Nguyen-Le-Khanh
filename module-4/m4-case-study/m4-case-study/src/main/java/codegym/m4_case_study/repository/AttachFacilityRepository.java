package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}