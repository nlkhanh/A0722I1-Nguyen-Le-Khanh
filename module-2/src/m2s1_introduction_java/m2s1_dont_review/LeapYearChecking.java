package m2s1_introduction_java.m2s1_dont_review;

import java.util.Scanner;

public class LeapYearChecking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ;");
        int year = input.nextInt();
        boolean isLeapYear = false;
        boolean isDivisible4 = year % 4 == 0;
        boolean isDivisible100 = year % 100 == 0;
        boolean isDivisible400 = year % 400 == 0;
        if (isDivisible4) {
            if (isDivisible100) {
                if (isDivisible400) {
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