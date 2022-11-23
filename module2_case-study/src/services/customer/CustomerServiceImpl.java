package services.customer;

import models.person.Customer;
import utils.user_exception.UserException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final LinkedList<Customer> CUSTOMERS;

    static {
        CUSTOMERS = new LinkedList<>();
    }

    public CustomerServiceImpl() {
    }

    @Override
    public void displayAll() {
        for (Customer customer : CUSTOMERS) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer code: ");
        String code = input.nextLine();
        System.out.println("Enter customer name: ");
        String name = input.nextLine();
        LocalDate birthdate;
        while (true) {
            try {
                birthdate = getBirthdate();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean gender = getGender();
        System.out.println("Enter customer ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter customer phone: ");
        int phone = Integer.parseInt(input.nextLine());
        System.out.println("Enter customer email: ");
        String email = input.nextLine();
        System.out.println("Enter customer address: ");
        String address = input.nextLine();
        String customerType = getCustomerType();
        CUSTOMERS.add(new Customer(code, name, birthdate, gender, id, phone, email, address, customerType));
    }

    @Override
    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of customer you want: ");
        String code = input.nextLine();
        for (Customer customer : CUSTOMERS) {
            if (customer.getPersonCode().equals(code)) {
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
                            System.out.println("Enter customer name: ");
                            String newName = input.nextLine();
                            customer.setName(newName);
                            break;
                        case 2:
                            while (true) {
                                try {
                                    customer.setBirthday(getBirthdate());
                                    break;
                                } catch (UserException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 3:
                            customer.setGender(getGender());
                            break;
                        case 4:
                            System.out.println("Enter customer ID: ");
                            int newId = Integer.parseInt(input.nextLine());
                            customer.setId(newId);
                            break;
                        case 5:
                            System.out.println("Enter customer phone: ");
                            int newPhone = Integer.parseInt(input.nextLine());
                            customer.setPhone(newPhone);
                            break;
                        case 6:
                            System.out.println("Enter customer email: ");
                            String newEmail = input.nextLine();
                            customer.setEmail(newEmail);
                            break;
                        case 7:
                            System.out.println("Enter customer address: ");
                            String newAddress = input.nextLine();
                            customer.setAddress(newAddress);
                            break;
                        case 8:
                            customer.setCustomerType(getCustomerType());
                            break;
                        case 0:
                            break;
                    }
                } while (choice != 0);
                System.out.println("Information after edited: ");
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Invalid code!");
    }

    private boolean getGender() {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        boolean gender = false;
        do {
            System.out.println("Choose customer gender: ");
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

    private String getCustomerType() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Choose a customer type: ");
            System.out.println("1. Diamond");
            System.out.println("2. Platinum");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
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
                    default:
                        System.out.println("Invalid choice! (Your input must be from 1 to 5)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        } while (choice < 1 || choice > 5);
        return null;
    }

    private LocalDate getBirthdate() throws UserException {
        Scanner input = new Scanner(System.in);
        String date;
        LocalDate birthDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter a birthdate: ");
        date = input.next();
        boolean isRightFormat = date.matches("^\\d{2}/\\d{2}/\\d{4}$");
        int day, month, year;
        if (!isRightFormat) {
            throw new UserException();
        } else {
            day = Integer.parseInt(date.substring(0, 2));
            month = Integer.parseInt(date.substring(3, 5));
            year = Integer.parseInt(date.substring(6));

            boolean isRightMonth = month >= 1 && month <= 12;
            if (!isRightMonth) {
                throw new UserException();
            }

            boolean isRightDay;
            switch (month) {
                case 2:
                    if (isLeapYear(year)) {
                        isRightDay = day >= 1 && day <= 29;
                    } else {
                        isRightDay = day >= 1 && day <= 28;
                    }
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    isRightDay = day >= 1 && day <= 31;
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    isRightDay = day >= 1 && day <= 30;
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
            }
        }
        birthDate = LocalDate.parse(date, formatter);
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        boolean isRightAge = age >= 18 && age <= 100;
        if (!isRightAge) {
            throw new UserException();
        } else {
            return birthDate;
        }
    }

    private boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
