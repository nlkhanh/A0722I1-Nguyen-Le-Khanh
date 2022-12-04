package services.person.customer;

import models.person.Customer;
import services.Service;

public interface CustomerService extends Service<Customer> {
    String getCustomerType();
}
