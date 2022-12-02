package repository.employee;

import models.person.Employee;
import repository.Repository;

import java.io.IOException;
import java.util.List;

public interface EmployeeRepository extends Repository {
    void add(Employee employee);

    void set(Employee employee);

    Employee find(String code);

    List<Employee> readCSV();

    void writeCSV(List<Employee> employees);
}
