package m2s10_dsa_stack_queue.review.expression_word_count_by_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExpressionWordCountByMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();
        String[] words = str.split("");

        Map<String, Integer> wordAmounts = new TreeMap<>();
        for (String word : words) {
            word = word.toUpperCase();
            if (wordAmounts.containsKey(word)) {
                wordAmounts.put(word, wordAmounts.get(word) + 1);
            } else {
                wordAmounts.put(word, 1);
            }
        }
        System.out.println(wordAmounts);
    }
}
