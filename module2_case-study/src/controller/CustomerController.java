package controller;

import services.person.customer.CustomerService;
import services.person.customer.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    public CustomerController() {
    }

    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        while (true) {
            try {
                System.out.println("---- Customer Management ----");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");
                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
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
                        return;
                    default:
                        System.out.println("Your choice must be from 1 to 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
