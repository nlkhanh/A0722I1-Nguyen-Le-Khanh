package m2s17_string_regex.review.validate_phone_number;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static final String PHONE_NUMBER_REGEX = "\\(\\d{2}\\)-\\(0\\d{9}\\)";

    public static boolean isRightPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a phone number: ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.equals("0")) {
                System.exit(0);
            }
            System.out.println(isRightPhoneNumber(phoneNumber));
        }
    }
}
