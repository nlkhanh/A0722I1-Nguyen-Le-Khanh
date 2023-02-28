package m2s3_method.m2s3_review;

import java.util.Scanner;

public class SumColumnTwoDimensionsArrayCalculator {
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
        System.out.println("Which column u want to get sum: ");
        int col;
        do {
            col = input.nextInt();
            if ((col < 0) || (col >= sizeCol)) {
                System.out.println("Column should not less than 0 and not exceed " + sizeCol);
            }
        } while ((col < 0) || (col >= sizeCol));
        int sum = 0;
        for (int[] ints : array) {
            sum += ints[col];
        }
        System.out.println("Sum of column " + col + " is " + sum);
    }
}