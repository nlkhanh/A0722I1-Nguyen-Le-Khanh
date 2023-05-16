package codegym.m4_case_study.service;

import codegym.m4_case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService extends GeneralService<Employee> {
    Page<Employee> findAllSearch(String search, Pageable pageable);
}
