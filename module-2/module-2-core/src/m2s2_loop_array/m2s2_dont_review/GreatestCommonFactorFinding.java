package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class GreatestCommonFactorFinding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int number1 = input.nextInt();
        System.out.println("Enter number 2: ");
        int number2 = input.nextInt();
        System.out.println("Two numbers you input is: " + number1 + " and " + number2);
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        if ((number1 == 0) || (number2 == 0)) {
            System.out.println("No greatest common factor");
        } else {
            do {
                if (number1 > number2) {
                    number1 -= number2;
                } else {
                    number2 -= number1;
                }
            } while (number1 != number2);
        }
        System.out.println("Greatest common factor of is: " + number1);
    }
}
