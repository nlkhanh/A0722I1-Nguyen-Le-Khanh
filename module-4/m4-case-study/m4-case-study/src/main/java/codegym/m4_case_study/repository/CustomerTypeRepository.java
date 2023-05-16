package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}