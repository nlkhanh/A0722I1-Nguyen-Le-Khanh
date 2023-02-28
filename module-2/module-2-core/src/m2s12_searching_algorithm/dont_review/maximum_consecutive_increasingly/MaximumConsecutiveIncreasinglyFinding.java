package m2s12_searching_algorithm.dont_review.maximum_consecutive_increasingly;

import java.util.LinkedList;
import java.util.Scanner;

public class MaximumConsecutiveIncreasinglyFinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (list.size() > 1 && str.charAt(i) <= list.getLast() && list.contains(str.charAt(i))) {
                list.clear();
            }
            list.add(str.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }

        for (Character ch: max) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
