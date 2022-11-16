package services.employee;

import models.person.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final ArrayList<Employee> EMPLOYEES;

    static {
        EMPLOYEES = new ArrayList<>();
    }

    public EmployeeServiceImpl() {
    }

    public void displayAll() {
        for (Employee employee : EMPLOYEES) {
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
        boolean gender = setGender();
        System.out.println("Enter employee ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee phone: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee email: ");
        String email = input.nextLine();
        System.out.println("Enter employee salary: ");
        int salary = Integer.parseInt(input.nextLine());
        String professional = setProfessional();
        String position = setPosition();
        EMPLOYEES.add(new Employee(code, name, birthdate, gender, id, phone, email, salary, professional, position));
    }

    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of employee you want: ");
        String code = input.nextLine();
        for (Employee employee : EMPLOYEES) {
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
                            employee.setGender(setGender());
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
                            employee.setProfessional(setProfessional());
                            break;
                        case 9:
                            employee.setPosition(setPosition());
                            break;
                        case 0:
                            break;
                    }
                } while (choice != 0);
                System.out.println("Information after edited: ");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Invalid code!");
    }

    private boolean setGender() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        boolean gender = false;
        do {
            System.out.println("Choose employee gender: ");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input!");
            } else {
                gender = (choice == 1);
            }
        } while (choice != 1 && choice != 2);
        return gender;
    }

    private String setProfessional() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        String professional = "";
        do {
            System.out.println("Choose new professional: ");
            System.out.println("1. Intermediate");
            System.out.println("2. College");
            System.out.println("3. University");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    professional = "Intermediate";
                    break;
                case 2:
                    professional = "College";
                    break;
                case 3:
                    professional = "University";
                    break;
            }
        } while (choice < 1 || choice > 3);
        return professional;
    }

    private String setPosition() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        String position = "";
        do {
            System.out.println("Choose new position: ");
            System.out.println("1. Receptionist");
            System.out.println("2. Staff");
            System.out.println("3. Expert");
            System.out.println("4. Supervisor");
            System.out.println("5. Manager");
            System.out.println("6. Director");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    position = "Receptionist";
                    break;
                case 2:
                    position = "Staff";
                    break;
                case 3:
                    position = "Expert";
                    break;
                case 4:
                    position = "Supervisor";
                    break;
                case 5:
                    position = "Manager";
                    break;
                case 6:
                    position = "Director";
                    break;
            }
        } while (choice < 1 || choice > 6);
        return position;
    }
}
