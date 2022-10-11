package m2s3_method.m2s3_review;

import java.util.Scanner;

public class MinValueInArrayFinding {
    public static int getMinValue(int[] numbers) {
        int min = numbers[0];
        for (int v : numbers) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if ((size > 20) || (size <= 0)) {
                System.out.println("Size should not less than 1 and not exceed 20");
            }
        } while ((size > 20) || (size <= 0));
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }
        System.out.print("Array list: ");
        for (int v : array) {
            System.out.print(v + "\t");
        }
        System.out.println("\nMinimum value of array is: " + getMinValue(array));
    }

}