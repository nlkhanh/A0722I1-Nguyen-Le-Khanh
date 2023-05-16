package codegym.m4_case_study.service;

import codegym.m4_case_study.model.ContractDetail;

import java.util.List;

public interface ContractDetailService extends GeneralService<ContractDetail> {
    List<ContractDetail> findAllByContractId(Long contractId);
}
