package repository.customer;

import models.person.Customer;
import repository.Repository;

import java.util.List;

public interface CustomerRepository extends Repository {
    void add(Customer customer);

    void set(Customer customer);

    Customer find(String code);

    List<Customer> readCSV();

    void writeCSV(List<Customer> customers);
}
