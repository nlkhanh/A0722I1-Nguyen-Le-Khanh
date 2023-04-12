package codegym.service.impl;

import codegym.exception.DuplicateEmailException;
import codegym.model.Customer;
import codegym.repository.CustomerRepository;
import codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) throws Exception {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        if (customer.getId() == null) {
            throw new Exception();
        }
        return customer;
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByNameContainingOrEmailContainingOrAddressContaining(String name, String email, String address, Pageable pageable) {
        return customerRepository.findAllByNameContainingOrEmailContainingOrAddressContaining(name, email, address, pageable);
    }
}
