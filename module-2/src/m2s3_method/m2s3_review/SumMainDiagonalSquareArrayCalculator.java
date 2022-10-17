package m2s3_method.m2s3_review;

import java.util.Arrays;
import java.util.Scanner;

public class SumMainDiagonalSquareArrayCalculator {

    public static int[] getSumMainDiagonal(int[][] array) {
        int firstNumber = 0;
        int secondNumber = 0;
        for (int i = 0; i < array.length; i++) {
            firstNumber += array[i][i];
            secondNumber += array[i][array.length - 1 - i];
        }
        return new int[]{firstNumber, secondNumber};
    }

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
        System.out.println("Sum main diagonal of square array is: " + Arrays.toString(getSumMainDiagonal(array)));
    }
}