package services.customer;

import models.person.Customer;
import repository.customer.CustomerRepositoryImpl;
import utils.user_exception.UserException;
import utils.user_exception.Validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final CustomerRepositoryImpl CUSTOMER_REPOSITORY;

    static {
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl();
    }

    public CustomerServiceImpl() {
    }

    @Override
    public void displayAll() {
        CUSTOMER_REPOSITORY.displayAll();
    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer code: ");
        String code = input.nextLine();
        System.out.println("Enter customer name: ");
        String name = input.nextLine();
        LocalDate birthdate = getBirthdate();
        boolean gender = getGender();
        int id;
        while (true) {
            try {
                System.out.println("Enter customer ID: ");
                id = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        int phone;
        while (true) {
            try {
                System.out.println("Enter customer phone: ");
                phone = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("Enter customer email: ");
        String email = input.nextLine();
        System.out.println("Enter customer address: ");
        String address = input.nextLine();
        String customerType = getCustomerType();
        CUSTOMER_REPOSITORY.add(new Customer(code, name, birthdate, gender, id, phone, email, address, customerType));
    }

    @Override
    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of customer you want: ");
        String code = input.nextLine();
        Customer customer = CUSTOMER_REPOSITORY.find(code);
        if (customer != null) {
            System.out.println("Customer you want to edit is: " + customer);
            while (true) {
                try {
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
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter customer name: ");
                            customer.setName(input.nextLine());
                            break;
                        case 2:
                            customer.setBirthday(getBirthdate());
                            break;
                        case 3:
                            customer.setGender(getGender());
                            break;
                        case 4:
                            while (true) {
                                try {
                                    System.out.println("Enter customer ID: ");
                                    customer.setId(Integer.parseInt(input.nextLine()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input!");
                                }
                            }
                            break;
                        case 5:
                            while (true) {
                                try {
                                    System.out.println("Enter customer phone: ");
                                    customer.setPhone(Integer.parseInt(input.nextLine()));
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input!");
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Enter customer email: ");
                            customer.setEmail(input.nextLine());
                            break;
                        case 7:
                            System.out.println("Enter customer address: ");
                            customer.setAddress(input.nextLine());
                            break;
                        case 8:
                            customer.setCustomerType(getCustomerType());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Your choice must be from 0 to 8!");
                    }
                    if (choice == 0) {
                        System.out.println("Customer after edit is: " + customer);
                        CUSTOMER_REPOSITORY.set(customer);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }
        }
        System.out.println("Invalid code!");
    }

    private boolean getGender() {
        while (true) {
            System.out.println("Choose customer gender: ");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("Enter your choice: ");
            try {
                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                if (choice == 1) {
                    return true;
                } else if (choice == 2) {
                    return false;
                }
                System.out.println("Your choice must be 1 or 2!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private String getCustomerType() {
        while (true) {
            System.out.println("Choose a customer type: ");
            System.out.println("1. Diamond");
            System.out.println("2. Platinum");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            System.out.println("Enter your choice: ");
            try {
                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        return "Diamond";
                    case 2:
                        return "Platinum";
                    case 3:
                        return "Gold";
                    case 4:
                        return "Silver";
                    case 5:
                        return "Member";
                }
                System.out.println("Invalid choice! (Your input must be from 1 to 5)");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private LocalDate getBirthdate() {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate;
        while (true) {
            try {
                System.out.println("Enter a birthdate: ");
                String date = input.next();
                if (Validate.isRightBirthDate(date)) {
                    birthDate = LocalDate.parse(date, formatter);
                    break;
                }
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        return birthDate;
    }
}
