package m2s1_introduction_java.m2s1_dont_review;

import java.util.Scanner;

public class DaysOfMonthCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your month: ");
        int month = input.nextInt();
        String daysOfMonth;
        switch (month) {
            case 2:
                daysOfMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysOfMonth = "30";
                break;
            default:
                daysOfMonth = "";
        }
        if (!daysOfMonth.equals("")) {
            System.out.println("The month: " + month + ", has " + daysOfMonth + " days!");
        } else {
            System.out.println("Invalid input!");
        }
    }
}