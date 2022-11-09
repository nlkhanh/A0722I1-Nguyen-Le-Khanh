package m2s10_dsa_stack_queue.review.expression_word_count_by_map;

import java.util.Scanner;
import java.util.TreeMap;

public class ExpressionWordCountByMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputStr = input.nextLine();
        String[] charsInStr = inputStr.split("");

        TreeMap<String, Integer> wordAmounts = new TreeMap<>();
        for (String charInStr : charsInStr) {
            charInStr = charInStr.toUpperCase();
            if (wordAmounts.containsKey(charInStr)) {
                wordAmounts.put(charInStr, wordAmounts.get(charInStr) + 1);
            } else {
                wordAmounts.put(charInStr, 1);
            }
        }
        System.out.println(wordAmounts);
    }
}
