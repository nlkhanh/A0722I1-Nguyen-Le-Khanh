package services.person;

import utils.UserException;
import utils.Validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class PersonServiceImpl implements PersonService{
    @Override
    public boolean getGender() {
        while (true) {
            System.out.println("Choose a gender: ");
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

    @Override
    public LocalDate getBirthdate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate;
        while (true) {
            try {
                System.out.println("Enter a birthdate: ");
                Scanner input = new Scanner(System.in);
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
