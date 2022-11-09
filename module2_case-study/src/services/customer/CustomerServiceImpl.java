package services.customer;

import models.person.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static ArrayList<Customer> customers;

    static {
        customers = new ArrayList<Customer>();
    }

    public CustomerServiceImpl() {
    }

    @Override
    public void displayAll() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Enter customer code: ");
        String code = input.nextLine();
        System.out.println("Enter customer name: ");
        String name = input.nextLine();
        System.out.println("Enter customer birthdate: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = input.nextLine();
        LocalDate birthdate = LocalDate.parse(date, formatter);
        boolean gender;
        do {
            System.out.println("Enter customer gender: ");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            gender = (choice == 1);
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input!");
            }
        } while (choice != 1 && choice != 2);
        System.out.println("Enter customer ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter customer phone: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.println("Enter customer email: ");
        String email = input.nextLine();
        System.out.println("Enter customer address: ");
        String address = input.nextLine();
        System.out.println("Enter customer type: ");
        String customerType = input.nextLine();
        customers.add(new Customer(code, name, birthdate, gender, id, phone, email, address, customerType));
    }

    @Override
    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of customer you want: ");
        String code = input.nextLine();
        for (Customer customer : customers) {
            if (Objects.equals(customer.getPersonCode(), code)) {
                System.out.println(customer);
                int choice;
                do {
                    System.out.println("What do you want to edit:?");
                    System.out.println("1. Name");
                    System.out.println("2. Birthdate");
                    System.out.println("3. Gender");
                    System.out.println("4. ID");
                    System.out.println("5. Phone");
                    System.out.println("6. Email");
                    System.out.println("7. Address");
                    System.out.println("8. Customer type");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter a new name: ");
                            String newName = input.nextLine();
                            customer.setName(newName);
                            break;
                        case 2:
                            System.out.println("Enter a new birthdate: ");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String date = input.next();
                            LocalDate newBirthdate = LocalDate.parse(date, formatter);
                            customer.setBirthday(newBirthdate);
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
                                        customer.setGender(true);
                                        break;
                                    case 2:
                                        customer.setGender(false);
                                        break;
                                    default:
                                        System.out.println("Invalid input!");
                                }
                            } while (choice != 1 && choice != 2);
                            break;
                        case 4:
                            System.out.println("Enter a new ID: ");
                            int newId = Integer.parseInt(input.nextLine());
                            customer.setId(newId);
                            break;
                        case 5:
                            System.out.println("Enter a new phone: ");
                            int newPhone = Integer.parseInt(input.nextLine());
                            customer.setPhone(newPhone);
                            break;
                        case 6:
                            System.out.println("Enter a new email: ");
                            String newEmail = input.nextLine();
                            customer.setEmail(newEmail);
                            break;
                        case 7:
                            System.out.println("Enter a new address: ");
                            String newAddress = input.nextLine();
                            customer.setAddress(newAddress);
                            break;
                        case 8:
                            System.out.println("Enter a new customer type: ");
                            String newCustomerType = input.nextLine();
                            customer.setCustomerType(newCustomerType);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Invalid input!");
                    }
                } while (choice != 0);
                System.out.println("Information after edited: ");
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Invalid code!");
    }
}
