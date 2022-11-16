package controllers;

import services.customer.CustomerServiceImpl;
import services.employee.EmployeeServiceImpl;
import services.facility.FacilityService;
import services.facility.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {

    public FuramaController() {
    }

    public static void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- Furama Resort Management ----");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    do {
                        System.out.println("---- Employee Management ----");
                        System.out.println("1. Display list employees");
                        System.out.println("2. Add new employee");
                        System.out.println("3. Edit employee");
                        System.out.println("4. Return main menu");
                        System.out.println("Enter your choice: ");
                        choice = Integer.parseInt(input.nextLine());
                        switch (choice) {
                            case 1:
                                employeeService.displayAll();
                                break;
                            case 2:
                                employeeService.add();
                                break;
                            case 3:
                                employeeService.set();
                                break;
                            case 4:
                                break;
                        }
                    } while (choice != 4);
                    break;
                case 2:
                    CustomerServiceImpl customerService = new CustomerServiceImpl();
                    do {
                        System.out.println("---- Customer Management ----");
                        System.out.println("1. Display list customers");
                        System.out.println("2. Add new customer");
                        System.out.println("3. Edit customer");
                        System.out.println("4. Return main menu");
                        choice = Integer.parseInt(input.nextLine());
                        switch (choice) {
                            case 1:
                                customerService.displayAll();
                                break;
                            case 2:
                                customerService.add();
                                break;
                            case 3:
                                customerService.set();
                                break;
                            case 4:
                                break;
                        }
                    } while (choice != 4);
                    break;
                case 3:
                    FacilityService facilityService = new FacilityServiceImpl();
                    do {
                        System.out.println("---- Facility Management ----");
                        System.out.println("1. Display list facility");
                        System.out.println("2. Add new facility");
                        System.out.println("3. Display list facility maintenance");
                        System.out.println("4. Return main menu");
                        choice = Integer.parseInt(input.nextLine());
                        switch (choice) {
                            case 1:
                                facilityService.displayAll();
                                break;
                            case 2:
                                facilityService.add();
                                break;
                            case 3:
                                facilityService.displayMaintenance();
                                break;
                            case 4:
                                break;
                        }
                    } while (choice != 4);
                    break;
                case 4:
                    System.out.println("---- Booking Management ----");
                    System.out.println("1. Add new booking");
                    System.out.println("2. Display list booking");
                    System.out.println("3. Create new contracts");
                    System.out.println("4. Display list contracts");
                    System.out.println("5. Edit contracts");
                    System.out.println("6. Return main menu");
                    choice = Integer.parseInt(input.nextLine());
                    break;
                case 5:
                    System.out.println("---- Promotion Management ----");
                    System.out.println("1. Display list customers use services");
                    System.out.println("2. Display list customers get voucher");
                    System.out.println("3. Return main menu");
                    choice = Integer.parseInt(input.nextLine());
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
