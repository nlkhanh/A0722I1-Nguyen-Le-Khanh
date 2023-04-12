package codegym.service;

import codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends GeneralService<Customer>{
    Page<Customer> findAllByNameContainingOrEmailContainingOrAddressContaining(String name, String email, String address, Pageable pageable);
}
