package service;

import model.Customer;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    private static final ICustomerRepository REPOSITORY = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return REPOSITORY.findAll();
    }

    @Override
    public void save(Customer customer) {
        REPOSITORY.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return REPOSITORY.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        REPOSITORY.update(id, customer);
    }

    @Override
    public void remove(int id) {
        REPOSITORY.remove(id);
    }
}