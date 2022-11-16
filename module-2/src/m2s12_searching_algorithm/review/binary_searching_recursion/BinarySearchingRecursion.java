package m2s12_searching_algorithm.review.binary_searching_recursion;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchingRecursion {
    public static int binarySearch(int[] arr, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (left <= right) {
            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] > value) {
                return binarySearch(arr, left, middle - 1, value);
            } else {
                return binarySearch(arr, middle + 1, right, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        arr[0] = 31;
        arr[1] = 20;
        arr[2] = 17;
        arr[3] = 59;
        arr[4] = 44;
        System.out.print("Array before sort: ");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.print("Array after sort: ");
        System.out.println(Arrays.toString(arr));
        int value = 1;
        System.out.println("Index of " + value + " is " + binarySearch(arr, 0, arr.length - 1, value));
    }
}
