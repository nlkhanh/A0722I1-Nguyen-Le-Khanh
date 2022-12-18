package services.person.customer;

import models.person.Customer;
import services.Service;

import java.util.List;

public interface CustomerService extends Service<Customer, List<Customer>> {
    String getCustomerType();
}
