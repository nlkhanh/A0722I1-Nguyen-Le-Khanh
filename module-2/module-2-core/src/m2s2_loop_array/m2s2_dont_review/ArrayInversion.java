package m2s2_loop_array.m2s2_dont_review;

import java.util.Scanner;

public class ArrayInversion {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a size:");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size dose not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }
        System.out.print("Element in array: ");
        for (int v : array) {
            System.out.print(v + "\t");
        }
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.print("\nElement in array: ");
        for (int v : array) {
            System.out.print(v + "\t");
        }
    }
}