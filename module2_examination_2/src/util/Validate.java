package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Validate {
    private static final String MEDICAL_CODE = "BA-\\d{3}";
    private static final String PATIENT_CODE = "BN-\\d{3}";
    private static final String DATE_FORMAT = "\\d{2}/\\d{2}/\\d{4}";

    public static boolean isMedicalCodeRight(String code) {
        return code.matches(MEDICAL_CODE);
    }

    public static boolean isPatientCodeRight(String code) {
        return code.matches(PATIENT_CODE);
    }

    public static boolean isDateRight(String dateStr) {
        if (!dateStr.matches(DATE_FORMAT)) {
            return false;
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dateArr = dateStr.split("/");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        if (month < 0 || month > 12) {
            return false;
        }
        Year year = Year.of(Integer.parseInt(dateArr[2]));
        if (year.isLeap()) {
            daysInMonth[1] = 29;
        }
        return day >= 0 && day<=daysInMonth[month - 1];
    }

    public static boolean isInOutDateRight(LocalDate inDate, LocalDate outDate) {
        return Period.between(inDate, outDate).getDays() >= 0;
    }
}
