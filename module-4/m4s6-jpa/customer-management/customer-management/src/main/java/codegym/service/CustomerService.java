package codegym.service;

import codegym.model.Customer;

public interface CustomerService extends GeneralService<Customer> {
    void insertWithStoredProcedure(Customer customer);
}
