package controller;

import services.person.employee.EmployeeService;
import services.person.employee.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {

    public EmployeeController() {
    }

    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();
        while (true) {
            try {
                System.out.println("---- Employee Management ----");
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Return main menu");
                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
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
