package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class PrimeNumberChecking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(number + " is a prime");
            } else {
                System.out.println(number + " is not a prime");
            }
        }
    }
}