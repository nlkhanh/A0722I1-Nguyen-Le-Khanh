package repository.employee;

import models.person.Employee;
import repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, List<Employee>> {
}
