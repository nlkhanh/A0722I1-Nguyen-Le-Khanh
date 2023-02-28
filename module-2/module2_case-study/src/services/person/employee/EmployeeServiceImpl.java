package services.person.employee;

import models.person.Employee;
import repository.employee.EmployeeRepositoryImpl;
import services.person.PersonServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends PersonServiceImpl implements EmployeeService {
    private static final EmployeeRepositoryImpl EMPLOYEE_REPOSITORY;

    static {
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl();
    }

    public EmployeeServiceImpl() {
    }

    @Override
    public void displayAll() {
        EMPLOYEE_REPOSITORY.displayAll();
    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter employee code: ");
        String code = input.nextLine();
        System.out.println("Enter employee name: ");
        String name = input.nextLine();
        LocalDate birthdate = getBirthdate();
        boolean gender = getGender();
        int id;
        while (true) {
            try {
                System.out.println("Enter employee ID: ");
                id = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        int phone;
        while (true) {
            try {
                System.out.println("Enter employee phone: ");
                phone = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("Enter employee email: ");
        String email = input.nextLine();
        int salary;
        while (true) {
            try {
                System.out.println("Enter employee salary: ");
                salary = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        String professional = setProfessional();
        String position = setPosition();
        EMPLOYEE_REPOSITORY.add(new Employee(code, name, birthdate, gender, id, phone, email, salary, professional, position));
    }

    @Override
    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of employee you want: ");
        String code = input.nextLine();
        Employee employee = EMPLOYEE_REPOSITORY.find(code);
        if (employee != null) {
            System.out.println("Employee you want to edit is: " + employee);
            while (true) {
                try {
                    System.out.println("What do you wanna edit:?");
                    System.out.println("1. Name");
                    System.out.println("2. Birthdate");
                    System.out.println("3. Gender");
                    System.out.println("4. ID");
                    System.out.println("5. Phone");
                    System.out.println("6. Email");
                    System.out.println("7. Salary");
                    System.out.println("8. Professional");
                    System.out.println("9. Position");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter employee name: ");
                            employee.setName(input.nextLine());
                            break;
                        case 2:
                            employee.setBirthday(getBirthdate());
                            break;
                        case 3:
                            employee.setGender(getGender());
                            break;
                        case 4:
                            while (true) {
                                try {
                                    System.out.println("Enter employee ID: ");
                                    employee.setId(Integer.parseInt(input.nextLine()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input!");
                                }
                            }
                            break;
                        case 5:
                            while (true) {
                                try {
                                    System.out.println("Enter employee phone: ");
                                    employee.setPhone(Integer.parseInt(input.nextLine()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input!");
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Enter employee email: ");
                            employee.setEmail(input.nextLine());
                            break;
                        case 7:
                            System.out.println("Enter employee salary: ");
                            employee.setSalary(Integer.parseInt(input.nextLine()));
                            break;
                        case 8:
                            employee.setProfessional(setProfessional());
                            break;
                        case 9:
                            employee.setPosition(setPosition());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Your choice must be from 0 to 9!");
                    }
                    if (choice == 0) {
                        EMPLOYEE_REPOSITORY.set(employee);
                        System.out.println("Employee after edited is: " + employee);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }

        }
        System.out.println("Invalid code!");
    }

    @Override
    public Employee find(String code) {
        return EMPLOYEE_REPOSITORY.find(code);
    }

    @Override
    public List<Employee> findAll() {
        return EMPLOYEE_REPOSITORY.read();
    }

    @Override
    public String setProfessional() {
        while (true) {
            System.out.println("Choose new professional: ");
            System.out.println("1. Intermediate");
            System.out.println("2. College");
            System.out.println("3. University");
            System.out.println("Enter your choice: ");
            try {
                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        return "Intermediate";
                    case 2:
                        return "College";
                    case 3:
                        return "University";
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    @Override
    public String setPosition() {
        while (true) {
            System.out.println("Choose new position: ");
            System.out.println("1. Receptionist");
            System.out.println("2. Staff");
            System.out.println("3. Expert");
            System.out.println("4. Supervisor");
            System.out.println("5. Manager");
            System.out.println("6. Director");
            System.out.println("Enter your choice: ");
            try {
                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        return "Receptionist";
                    case 2:
                        return "Staff";
                    case 3:
                        return "Expert";
                    case 4:
                        return "Supervisor";
                    case 5:
                        return "Manager";
                    case 6:
                        return "Director";
                }
                System.out.println("Your choice must be from 1 to 6!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
