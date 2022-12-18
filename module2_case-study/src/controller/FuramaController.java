package controller;

import java.util.Scanner;

public class FuramaController {

    public FuramaController() {
    }

    public static void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            try {
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
                        EmployeeController employeeController = new EmployeeController();
                        employeeController.displayMainMenu();
                        break;
                    case 2:
                        CustomerController customerController = new CustomerController();
                        customerController.displayMainMenu();
                        break;
                    case 3:
                        FacilityController facilityController = new FacilityController();
                        facilityController.displayMainMenu();
                        break;
                    case 4:
                        BookingController bookingController = new BookingController();
                        bookingController.displayMainMenu();
                        break;
                    case 5:
                        PromotionController promotionController = new PromotionController();
                        promotionController.displayMainMenu();
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
