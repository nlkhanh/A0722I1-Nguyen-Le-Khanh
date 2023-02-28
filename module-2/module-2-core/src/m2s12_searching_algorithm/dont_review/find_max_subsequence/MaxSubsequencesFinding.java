package m2s12_searching_algorithm.dont_review.find_max_subsequence;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxSubsequencesFinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputStr = scanner.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < inputStr.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(inputStr.charAt(i));
            for (int j = i + 1; j < inputStr.length(); j++) {
                if (inputStr.charAt(j) > list.getLast()) {
                    list.add(inputStr.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        System.out.print("Max subsequence is: ");
        for (Character ch : max) {
            System.out.print(ch + "\t");
        }
    }
}
