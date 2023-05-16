package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}