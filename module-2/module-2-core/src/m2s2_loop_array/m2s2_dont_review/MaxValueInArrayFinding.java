package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class MaxValueInArrayFinding {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }
        System.out.print("Property list: ");
        for (int v : array) {
            System.out.print(v + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i + 1;
            }
        }
        System.out.println("\nThe largest property value in the list is " + max + ", at position " + index);
    }
}