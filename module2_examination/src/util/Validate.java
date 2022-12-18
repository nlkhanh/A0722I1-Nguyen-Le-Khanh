package util;

public class Validate {
    private static final String DATE_FORMAT = "(0[1-9]|1[0-9]|2[0-9]|3[01])\\/(0[1-9]|1[0-2]\\/\\d{4})";

    private static final String CARD_NUMBER = "\\d*";

    private static final String ACCOUNT_CODE = "\\d{9}";

    public static boolean isDateFormatRight(String dateStr) {
        return dateStr.matches(DATE_FORMAT);
    }

    public static boolean isCardNumberRight(String cardNumber) {
        return cardNumber.matches(CARD_NUMBER);
    }

    public static boolean isAccountCodeRight(String code) {
        return code.matches(ACCOUNT_CODE);
    }
}
