package m2s2_loop_array.m2s2_review;

import java.util.Scanner;

public class RemovingElementFromArray {
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
        System.out.print("Your array is: ");
        for (int v : array) {
            System.out.print(v + "\t");
        }
        System.out.println("\nEnter the element you want to delete: ");
        int inputElement = input.nextInt();
        int index = -1;
        boolean isExist = false;
        do {
            isExist = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == inputElement) {
                    index = i;
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                for (; index < (array.length - 1); index++) {
                    array[index] = array[index + 1];
                }
                array[index] = 0;
            }
        } while (isExist);
        if (index != -1) {
            System.out.print("\nNew array is: ");
            for (int v : array) {
                System.out.print(v + "\t");
            }
        } else {
            System.out.println("Your element is not in array");
        }
    }
}