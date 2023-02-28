package m2s1_introduction_java.m2s1_review;

import java.util.Scanner;

public class GreetingDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yourName;
        System.out.println("Enter your name: ");
        yourName = scanner.nextLine();
        System.out.println("Hello: " + yourName);
    }
}