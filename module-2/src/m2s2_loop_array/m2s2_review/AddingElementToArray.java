package m2s2_loop_array.m2s2_review;

import java.util.Scanner;

public class AddingElementToArray {
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
        System.out.println("Enter a element you want to add: ");
        int element = input.nextInt();
        System.out.println("Enter a position you want to add: ");
        int index = input.nextInt();
        if ((index >= 0) && (index <= (array.length - 1))) {
            for (int i = (array.length - 1); i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
            System.out.print("Your new array: ");
            for (int v : array) {
                System.out.print(v + "\t");
            }
        } else {
            System.out.println("Your position should has value from 0  to " + (array.length - 1));
        }
    }
}
