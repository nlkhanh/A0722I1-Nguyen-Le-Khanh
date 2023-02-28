package m2s1_introduction_java.m2s1_dont_review;

import java.util.Scanner;

public class OperatorUsing {
    public static void main(String[] args) {
        System.out.println("Calculating area of rectangle");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your rectangle's width: ");
        float width = input.nextFloat();
        System.out.println("Enter your rectangle's height: ");
        float height = input.nextFloat();
        float area = width * height;
        System.out.println("Area of your rectangle is: " + area);
    }
}