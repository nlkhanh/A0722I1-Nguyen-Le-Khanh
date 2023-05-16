package codegym.m4_case_study.service;

import codegym.m4_case_study.dto.ContractDto;
import codegym.m4_case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService extends GeneralService<Contract> {
    Page<ContractDto> findAllContractDto (Pageable pageable);
}
