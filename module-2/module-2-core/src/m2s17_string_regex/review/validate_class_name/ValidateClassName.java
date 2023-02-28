package m2s17_string_regex.review.validate_class_name;

import java.util.Scanner;

public class ValidateClassName {
    private static final String CLASS_NAME_REGEX = "[CAP]\\d{4}[GHIKLM]";

    public static boolean isRightClassName(String className) {
        return className.matches(CLASS_NAME_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String className;
        while (true) {
            System.out.println("Enter your class name: ");
            className = scanner.nextLine();
            if (className.equals("0")) {
                System.exit(0);
            }
            System.out.println(isRightClassName(className));
        }
    }
}
