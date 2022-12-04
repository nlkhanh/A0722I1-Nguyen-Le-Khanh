package controller;

import services.facility.FacilityService;
import services.facility.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    public FacilityController() {
    }

    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        FacilityService facilityService = new FacilityServiceImpl();
        while (true) {
            try {
                System.out.println("---- Facility Management ----");
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return main menu");
                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
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
                        return;
                    default:
                        System.out.println("Your choice must be from 1 to 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid inout");
            }
        }
    }
}
