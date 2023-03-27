package codegym.repository;

import codegym.model.Customer;

public interface CustomerRepository extends GeneralRepository<Customer> {
    void insertWithStoredProcedure(Customer customer);
}
