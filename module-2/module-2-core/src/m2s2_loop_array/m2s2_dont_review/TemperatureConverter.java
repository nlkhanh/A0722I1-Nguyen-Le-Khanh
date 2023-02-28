package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5.0) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9.0) * (fahrenheit - 32);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your fahrenheit: ");
                    double fahrenheit = input.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter your celsius: ");
                    double celsius = input.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice != 0);
    }
}