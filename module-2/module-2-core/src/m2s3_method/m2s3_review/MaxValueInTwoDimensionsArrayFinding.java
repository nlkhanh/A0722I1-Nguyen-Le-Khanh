package m2s3_method.m2s3_review;

import java.util.Scanner;

public class MaxValueInTwoDimensionsArrayFinding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeRow;
        int sizeCol;
        do {
            System.out.println("Enter a size row: ");
            sizeRow = input.nextInt();
            if ((sizeRow > 10) || (sizeRow <= 0)) {
                System.out.println("Size row should not exceed 10 and more than 0");
            }
        } while ((sizeRow > 10) || (sizeRow <= 0));
        do {
            System.out.println("Enter a size col: ");
            sizeCol = input.nextInt();
            if ((sizeCol > 10) || (sizeCol <= 0)) {
                System.out.println("Size col should not exceed 10 and more than 0");
            }
        } while ((sizeCol > 10) || (sizeCol <= 0));
        int[][] array = new int[sizeRow][sizeCol];
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
        int max = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        System.out.println("Max element in Array is: " + max);
    }
}