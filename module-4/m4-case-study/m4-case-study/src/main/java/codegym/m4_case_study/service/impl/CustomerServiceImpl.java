package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.model.Facility;
import codegym.m4_case_study.repository.CustomerRepository;
import codegym.m4_case_study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        customerRepository.deleteAllByIdIn(deleteIds);
    }

    @Override
    public Page<Customer> findAllSearch(String search, Pageable pageable) {
        return customerRepository.findAllSearch(search, pageable);
    }
}
