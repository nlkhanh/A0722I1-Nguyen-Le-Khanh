package services.employee;

import models.person.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> employees;

    static {
        employees = new ArrayList<Employee>();
    }

    public EmployeeServiceImpl() {
    }

    public void displayAll() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void add() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Enter employee code: ");
        String code = input.nextLine();
        System.out.println("Enter employee name: ");
        String name = input.nextLine();
        System.out.println("Enter employee birthdate: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = input.nextLine();
        LocalDate birthdate = LocalDate.parse(date, formatter);
        boolean gender;
        do {
            System.out.println("Enter employee gender: ");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            gender = (choice == 1);
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input!");
            }
        } while (choice != 1 && choice != 2);
        System.out.println("Enter employee ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee phone: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee email: ");
        String email = input.nextLine();
        System.out.println("Enter employee salary: ");
        int salary = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee professional: ");
        String professional = input.nextLine();
        System.out.println("Enter employee position: ");
        String position = input.nextLine();
        employees.add(new Employee(code, name, birthdate, gender, id, phone, email, salary, professional, position));
    }

    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of employee you want: ");
        String code = input.nextLine();
        for (Employee employee : employees) {
            if (Objects.equals(employee.getPersonCode(), code)) {
                System.out.println(employee);
                int choice;
                do {
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
                    choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter a new name: ");
                            String newName = input.nextLine();
                            employee.setName(newName);
                            break;
                        case 2:
                            System.out.println("Enter a new birthdate: ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String date = input.next();
                            LocalDate newBirthdate = LocalDate.parse(date, formatter);
                            employee.setBirthday(newBirthdate);
                            break;
                        case 3:
                            do {
                                System.out.println("Choice your gender: ");
                                System.out.println("1. Male");
                                System.out.println("2. Female");
                                System.out.println("Enter your choice: ");
                                choice = Integer.parseInt(input.nextLine());
                                switch (choice) {
                                    case 1:
                                        employee.setGender(true);
                                        break;
                                    case 2:
                                        employee.setGender(false);
                                        break;
                                    default:
                                        System.out.println("Invalid input!");
                                }
                                if (choice != 1 && choice != 2) {
                                    System.out.println("Invalid input!");
                                }
                            } while (choice != 1 && choice != 2);
                            break;
                        case 4:
                            System.out.println("Enter a new ID: ");
                            int newId = Integer.parseInt(input.nextLine());
                            employee.setId(newId);
                            break;
                        case 5:
                            System.out.println("Enter a new phone: ");
                            int newPhone = Integer.parseInt(input.nextLine());
                            employee.setPhone(newPhone);
                            break;
                        case 6:
                            System.out.println("Enter a new email: ");
                            String newEmail = input.nextLine();
                            employee.setEmail(newEmail);
                            break;
                        case 7:
                            System.out.println("Enter a new salary: ");
                            int newSalary = Integer.parseInt(input.nextLine());
                            employee.setSalary(newSalary);
                            break;
                        case 8:
                            System.out.println("Enter a new professional: ");
                            String newProfessional = input.nextLine();
                            employee.setProfessional(newProfessional);
                            break;
                        case 9:
                            System.out.println("Enter a new position: ");
                            String newPosition = input.nextLine();
                            employee.setPosition(newPosition);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Invalid input!");
                    }
                } while (choice != 0);
                System.out.println("Information after edited: ");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Invalid code!");
    }
}
