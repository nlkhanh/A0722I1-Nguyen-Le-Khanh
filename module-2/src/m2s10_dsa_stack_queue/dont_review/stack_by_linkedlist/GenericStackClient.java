package m2s10_dsa_stack_queue.dont_review.stack_by_linkedlist;

public class GenericStackClient {
    private static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("five");
        stack.push("four");
        stack.push("three");
        stack.push("two");
        stack.push("one");
        System.out.println("1.1. Size of stack after push operation: " + stack.size());
        System.out.println("1.2. Pop element from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operation: " + stack.size());
    }

    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1. Size of stack after push operation: " + stack.size());
        System.out.println("2.2. Pop element from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
        System.out.println("\n2.3. Size of stack after pop operation: " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of Strings: ");
        stackOfStrings();
        System.out.println();
        System.out.println("2. Stack of Integers: ");
        stackOfIntegers();
    }
}
