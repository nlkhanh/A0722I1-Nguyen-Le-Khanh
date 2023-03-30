package codegym.service;

import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService extends GeneralService<Customer> {
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
