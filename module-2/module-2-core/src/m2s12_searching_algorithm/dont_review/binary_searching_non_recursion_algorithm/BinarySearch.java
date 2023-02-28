package m2s12_searching_algorithm.dont_review.binary_searching_non_recursion_algorithm;

public class BinarySearch {
    static int[] numbers = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(numbers, 2));  /* 0 */
        System.out.println(binarySearch(numbers, 11)); /* 4 */
        System.out.println(binarySearch(numbers, 79)); /*12 */
        System.out.println(binarySearch(numbers, 1));  /*-1 */
        System.out.println(binarySearch(numbers, 5));  /*-1 */
        System.out.println(binarySearch(numbers, 80));
    }
}
