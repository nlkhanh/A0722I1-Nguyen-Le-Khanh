package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Validate {
    private static final String VILLACODE = "^SVVL-\\d{5}$";

    private static final String HOUSECODE = "^SVVL-\\d{5}$";

    private static final String ROOMCODE = "^SVVL-\\d{5}$";

    private static final String NAMEORTYPE = "^[A-Z][a-z]+$";

    private static final String DATE = "^\\d{2}/\\d{2}/\\d{4}$";

    private Validate() {
    }

    public static boolean isRightServiceCode(String code, int serviceTypeCode) {
        if (serviceTypeCode == 1) {
            return code.matches(VILLACODE);
        } else if (serviceTypeCode == 2) {
            return code.matches(HOUSECODE);
        }
        return code.matches(ROOMCODE);
    }

    public static boolean isRightNameOrType(String name) {
        return name.matches(NAMEORTYPE);
    }

    public static boolean isRightArea(double area) {
        return area > 30;
    }

    public static boolean isRightCost(double cost) {
        return cost > 0;
    }

    public static boolean isRightNumberOfPeople(int numberOfPeople) {
        return (numberOfPeople > 0) && (numberOfPeople < 20);
    }

    public static boolean isRightDateFormat(String date) {return date.matches(DATE);}

    public static boolean isRightNumberOfFloor(int numberOfFloor) {
        return numberOfFloor > 0;
    }

    public static boolean isRightBirthDate(String date) throws UserException {
        boolean isRightFormat = isRightDateFormat(date);
        int day, month, year;
        if (!isRightFormat) {
            throw new UserException();
        } else {
            day = Integer.parseInt(date.substring(0, 2));
            month = Integer.parseInt(date.substring(3, 5));
            year = Integer.parseInt(date.substring(6));

            boolean isRightMonth = month >= 1 && month <= 12;
            if (!isRightMonth) {
                throw new UserException();
            }
            boolean isRightDay;
            switch (month) {
                case 2:
                    if (isLeapYear(year)) {
                        isRightDay = day >= 1 && day <= 29;
                    } else {
                        isRightDay = day >= 1 && day <= 28;
                    }
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    isRightDay = day >= 1 && day <= 31;
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    isRightDay = day >= 1 && day <= 30;
                    if (!isRightDay) {
                        throw new UserException();
                    }
                    break;
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        boolean isRightAge = age >= 18 && age <= 100;
        if (!isRightAge) {
            throw new UserException();
        } else {
            return true;
        }
    }

    private static boolean isLeapYear(int year) {
        boolean isDivisibleBy4 = (year % 4 == 0);
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = (year % 100 == 0);
            if (isDivisibleBy100) {
                return (year % 400 == 0);
            } else {
                return true;
            }
        }
        return false;
    }
}
