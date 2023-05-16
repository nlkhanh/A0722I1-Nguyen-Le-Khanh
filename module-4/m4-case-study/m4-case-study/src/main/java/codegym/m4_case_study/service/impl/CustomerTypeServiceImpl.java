package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.CustomerType;
import codegym.m4_case_study.repository.CustomerTypeRepository;
import codegym.m4_case_study.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return customerTypeRepository.save(customerType);
    }

    @Override
    public void deleteById(Long id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        customerTypeRepository.deleteAllByIdIn(deleteIds);
    }
}
