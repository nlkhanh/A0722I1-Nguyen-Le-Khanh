package codegym.repository;

import codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
