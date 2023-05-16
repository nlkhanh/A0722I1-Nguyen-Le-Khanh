package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.ContractDetail;
import codegym.m4_case_study.repository.ContractDetailRepository;
import codegym.m4_case_study.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteById(Long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        contractDetailRepository.deleteAllByIdIn(deleteIds);
    }

    @Override
    public List<ContractDetail> findAllByContractId(Long contractId) {
        return contractDetailRepository.findAllByContractId(contractId);
    }
}
