package m2s2_loop_array.m2s2_review;

import java.util.Scanner;

public class ArraysCombination {
    public static void main(String[] args) {
        int size1, size2;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size of array 1: ");
            size1 = input.nextInt();
            if (size1 <= 0) {
                System.out.println("The size should not less than 1");
            }
        } while (size1 <= 0);
        int[] array1 = new int[size1];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Array 1: enter element " + (i + 1) + ": ");
            array1[i] = input.nextInt();
        }
        System.out.print("Array 1: ");
        for (int v : array1) {
            System.out.print(v + "\t");
        }
        do {
            System.out.println("Enter a size of array 2: ");
            size2 = input.nextInt();
            if (size2 <= 0) {
                System.out.println("The size should not less than 1");
            }
        } while (size2 <= 0);
        int[] array2 = new int[size2];
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Array 2: enter element " + (i + 1) + ": ");
            array2[i] = input.nextInt() ;
        }
        System.out.print("\nArray 2: ");
        for (int v : array2) {
            System.out.print(v + "\t");
        }
        int[] array3 = new int[size1 + size2];
        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);
        System.out.println("\nYour new array: ");
        for (int v : array3) {
            System.out.print(v + "\t");
        }
    }
}
