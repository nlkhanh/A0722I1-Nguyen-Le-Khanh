package codegym.m4_case_study.service;

import codegym.m4_case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends GeneralService<Customer> {
    Page<Customer> findAllSearch(String search, Pageable pageable);
}
