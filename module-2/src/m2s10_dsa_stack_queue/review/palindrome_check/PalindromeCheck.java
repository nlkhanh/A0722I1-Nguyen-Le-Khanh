package m2s10_dsa_stack_queue.review.palindrome_check;

import java.util.*;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();
        String[] temp = str.split("");
        Queue<String> strQueue = new LinkedList<>();
        Stack<String> strStack = new Stack<>();

        for (String v : temp) {
            v = v.toLowerCase();
            strQueue.offer(v);
            strStack.push(v);
        }

        boolean isEqual = true;
        for (int i = 0; i < strQueue.size(); i++) {
            if (!Objects.equals(strQueue.poll(), strStack.pop())) {
                isEqual = false;
                break;
            }
        }

        if (isEqual) {
            System.out.println("Your string is a palindrome");
        } else {
            System.out.println("Your string is NOT a palindrome");
        }
    }
}
