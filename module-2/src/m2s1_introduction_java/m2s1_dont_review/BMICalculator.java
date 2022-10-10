package m2s1_introduction_java.m2s1_dont_review;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Your weight (in kilogram): ");
        double weight = input.nextDouble();
        System.out.println("Your height (in meter): ");
        double height = input.nextDouble();
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18) {
            System.out.println(bmi + ": Underweight");
        } else if (bmi < 25) {
            System.out.println(bmi + ": Normal");
        } else if (bmi < 30) {
            System.out.println(bmi + ": Overweight");
        } else {
            System.out.println(bmi + ": Obese");
        }
    }
}