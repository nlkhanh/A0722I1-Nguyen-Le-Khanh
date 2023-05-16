package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.dto.ContractDto;
import codegym.m4_case_study.model.Contract;
import codegym.m4_case_study.repository.ContractRepository;
import codegym.m4_case_study.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        contractRepository.deleteAllByIdIn(deleteIds);
    }

    @Override
    public Page<ContractDto> findAllContractDto(Pageable pageable) {
        List<Contract> contracts = findAll();
        List<ContractDto> contractDtos = new ArrayList<>();

        if (!contracts.isEmpty()) {
            for (Contract contract : contracts) {
                contractDtos.add(contract.entityToDto());
            }
        }

        return new PageImpl<>(contractDtos, pageable, contracts.size());
    }
}
