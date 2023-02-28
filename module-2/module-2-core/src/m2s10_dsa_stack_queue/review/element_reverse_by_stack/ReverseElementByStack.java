package m2s10_dsa_stack_queue.review.element_reverse_by_stack;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseElementByStack {
    public static void main(String[] args) {
        System.out.println("-----Reverse An Integer Array-----");
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> myArr = new ArrayList<>();
        myArr.add(0);
        myArr.add(1);
        myArr.add(2);
        myArr.add(3);
        myArr.add(4);
        myArr.add(5);
        myArr.add(6);
        myArr.add(7);
        myArr.add(8);
        myArr.add(9);

        System.out.println("Array before reverse: ");
        for (Integer element : myArr) {
            System.out.print(element + "\t");
        }
        System.out.println();

        for (Integer element : myArr) {
            stack.push(element);
        }
        for (int i = 0; i < myArr.size(); i++) {
            myArr.set(i, stack.pop());
        }

        System.out.println("Array after reverse: ");
        for (Integer element : myArr) {
            System.out.print(element + "\t");
        }
        System.out.println();

        System.out.println();
        System.out.println("-----Reverse An String Array-----");
        Stack<String> wStack = new Stack<>();
        String mWord = "codegymDaNang";
        String[] mWordArr = mWord.split("");

        System.out.println("Array before reverse: ");
        for (String element : mWordArr) {
            System.out.print(element + "\t");
        }
        System.out.println();

        for (String element : mWordArr) {
            wStack.push(element);
        }
        for (int i = 0; i < mWordArr.length; i++) {
            mWordArr[i] = wStack.pop();
        }

        System.out.println("Array after reverse: ");
        for (String element : mWordArr) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
