package m2s1_introduction_java.m2s1_dont_review;

import java.util.Scanner;

public class LeapYearChecking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ;");
        int year = input.nextInt();
        boolean isLeapYear = false;
        boolean isDivisibleFour = year % 4 == 0;
        if (isDivisibleFour) {
            boolean isDivisibleAHundred = year % 100 == 0;
            if (isDivisibleAHundred) {
                boolean isDivisibleFourHundred = year % 400 == 0;
                if (isDivisibleFourHundred) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        if (isLeapYear) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is NOT a leap year!");
        }
    }
}