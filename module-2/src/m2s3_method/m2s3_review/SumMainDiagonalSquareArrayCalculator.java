package m2s3_method.m2s3_review;

import java.util.Scanner;

public class SumMainDiagonalSquareArrayCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if ((size > 5) || (size <= 0)) {
                System.out.println("Size should not exceed 5");
            }
        } while ((size > 5) || (size <= 0));
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Enter element [" + i + "][" + j + "]: ");
                array[i][j] = input.nextInt();
            }
        }
        System.out.println("Your 2d array is: ");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        System.out.println("Sum of main diagonal line is " + sum);
    }
}