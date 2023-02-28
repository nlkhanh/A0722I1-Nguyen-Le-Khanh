package services.person.employee;

import models.person.Employee;
import services.Service;

import java.util.List;

public interface EmployeeService extends Service<Employee, List<Employee>> {
    String setProfessional();
    String setPosition();
}
