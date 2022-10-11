package m2s3_method.m2s3_dont_review;

import java.util.Scanner;

public class StudentPassedAmountCounting {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if ((size > 10) || (size <= 0)) {
                System.out.println("Size should not exceed 10 and more than 0");
            }
        } while ((size > 10) || (size <= 0));
        int[] scores = new int[size];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Enter score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }
        int count = 0;
        System.out.print("List of score: ");
        for (int v : scores) {
            System.out.print(v + " ");
            if ((v >= 5) && (v <= 10)) {
                count++;
            }
        }
        System.out.println("\nThe number of students passing the exam is " + count);
    }
}