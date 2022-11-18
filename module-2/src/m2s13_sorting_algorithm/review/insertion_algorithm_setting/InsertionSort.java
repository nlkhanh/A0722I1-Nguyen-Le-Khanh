package m2s13_sorting_algorithm.review.insertion_algorithm_setting;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] list) {
        int value;
        int index;
        for (int i = 1; i < list.length; i++) {
            value = list[i];
            index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (value < list[j]) {
                    list[j+1] = list[j];
                    index = j;
                }
            }
            list[index] = value;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int n : list) {
            System.out.println(n + "\t");
        }
    }
}
