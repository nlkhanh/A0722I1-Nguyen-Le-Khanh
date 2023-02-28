package m2s3_method.m2s3_review;

import java.util.Scanner;

public class NumberOfTimesAppearCharCounting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();
        System.out.println("Your string is: " + str);
        System.out.println("Enter a character: ");
        char inputChar = input.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == inputChar) {
                count++;
            }
        }
        System.out.println("Amount of " + inputChar + " in " + str + " is " + count);
    }
}