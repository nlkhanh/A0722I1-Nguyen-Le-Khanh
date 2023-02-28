package com;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validate {
    private static final String CUSTOMER_CODE = "KH-\\d{4}";
    private static final String SERVICE_CODE = "^DV-\\d{4}$";
    private static final String PHONE_NUMBER = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$";
    private static final String ID_CARD = "^(\\d{9})|(\\d{12})$";
    private static final String EMAIL = "^(.+)@(\\S+)$";
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isCustomerCodeRight(String customerCode) {
        return customerCode.matches(CUSTOMER_CODE);
    }

    public static boolean isServiceCodeRight(String serviceCode) {
        return serviceCode.matches(SERVICE_CODE);
    }

    public static boolean isPhoneNumberRight(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER);
    }

    public static boolean isIdCardRight(String idCard) {
        return idCard.matches(ID_CARD);
    }

    public static boolean isEmailRight(String email) {
        return email.matches(EMAIL);
    }

    public static boolean isDateRight(String date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isIntegerPositiveRight(String integerStr) {
        try {
            int integer = Integer.parseInt(integerStr);
            if (integer > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static boolean isDoublePositiveRight(String doubleStr) {
        try {
            double dou = Double.parseDouble(doubleStr);
            if (dou > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
