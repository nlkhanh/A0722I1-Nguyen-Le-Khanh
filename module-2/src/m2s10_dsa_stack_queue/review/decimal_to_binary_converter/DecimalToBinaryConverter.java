package m2s10_dsa_stack_queue.review.decimal_to_binary_converter;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int number = Integer.parseInt(input.nextLine());
        while (number != 0) {
            myStack.push(number % 2);
            number /= 2;
        }
        System.out.print("Your number after convert to binary: ");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop());
        }
    }
}
