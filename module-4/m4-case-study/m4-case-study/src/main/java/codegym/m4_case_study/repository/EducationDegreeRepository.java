package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}