package m2s10_dsa_stack_queue.dont_review.bracket_in_equation_check;

import java.util.Stack;

public class BracketEquationCheck {
    public static boolean bracketCheck(String equation) {
        String[] eArr = equation.split("");
        Stack<String> bStack = new Stack<>();
        for (String v : eArr) {
            if (v.equals("(")) {
                bStack.push(v);
            } else if (v.equals(")")) {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    String left = bStack.pop();
                    if (left == null) {
                        return false;
                    }
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        String firstEquation = "s * (s – a) * (s – b) * (s – c) ";
        String secondEquation = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String thirdEquation = "s * (s – a) * (s – b * (s – c)";
        String fourthEquation = "s * (s – a) * s – b) * (s – c)";
        String fifthEquation = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        System.out.println(bracketCheck(firstEquation));
        System.out.println(bracketCheck(secondEquation));
        System.out.println(bracketCheck(thirdEquation));
        System.out.println(bracketCheck(fourthEquation));
        System.out.println(bracketCheck(fifthEquation));
    }
}
