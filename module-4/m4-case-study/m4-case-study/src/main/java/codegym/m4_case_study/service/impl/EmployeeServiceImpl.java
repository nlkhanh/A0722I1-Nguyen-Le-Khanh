package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.model.Employee;
import codegym.m4_case_study.repository.EmployeeRepository;
import codegym.m4_case_study.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        employeeRepository.deleteAllByIdIn(deleteIds);
    }

    @Override
    public Page<Employee> findAllSearch(String search, Pageable pageable) {
        return employeeRepository.findAllSearch(search, pageable);
    }
}
