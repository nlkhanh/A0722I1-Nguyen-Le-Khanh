package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Contract;
import codegym.m4_case_study.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);

    @Query("select c from ContractDetail c where c.contract.id = :contractId")
    List<ContractDetail> findAllByContractId(@Param("contractId") Long contractId);
}