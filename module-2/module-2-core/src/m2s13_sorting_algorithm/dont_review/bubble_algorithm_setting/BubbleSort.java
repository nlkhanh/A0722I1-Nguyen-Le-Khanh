package m2s13_sorting_algorithm.dont_review.bubble_algorithm_setting;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int j : list) System.out.print(j + " ");
    }
}
