package codegym.service;

import codegym.model.Customer;
import codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customerRepository.save(customers);
    }

    @Override
    public boolean exists(Long id) {
        return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return customerRepository.findAll(ids);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
