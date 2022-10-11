package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money = input.nextDouble();
        System.out.println("Enter number of months: ");
        int month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        double interestRate = input.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}