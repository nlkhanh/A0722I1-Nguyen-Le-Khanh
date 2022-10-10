package m2s1_introduction_java.m2s1_review;

import java.util.Scanner;

public class NumberReader {
    static String readNum1(String num) {
        String numStr = null;
        switch (num) {
            case "0":
                numStr = "zero";
                break;
            case "1":
                numStr = "one";
                break;
            case "2":
                numStr = "two";
                break;
            case "3":
                numStr = "three";
                break;
            case "4":
                numStr = "four";
                break;
            case "5":
                numStr = "five";
                break;
            case "6":
                numStr = "six";
                break;
            case "7":
                numStr = "seven";
                break;
            case "8":
                numStr = "eight";
                break;
            case "9":
                numStr = "nine";
                break;
        }
        return numStr;
    }

    static String readNum2(String num) {
        String numStr = null;
        switch (num) {
            case "10":
                numStr = "ten";
                break;
            case "11":
                numStr = "eleven";
                break;
            case "12":
                numStr = "twelve";
                break;
            case "13":
                numStr = "thirteen";
                break;
            case "14":
                numStr = "fourteen";
                break;
            case "15":
                numStr = "fifteen";
                break;
            case "16":
                numStr = "sixteen";
                break;
            case "17":
                numStr = "seventeen";
                break;
            case "18":
                numStr = "eighteen";
                break;
            case "19":
                numStr = "nineteen";
                break;
        }
        return numStr;
    }

    static String readNum3(String num) {
        String numStr = null;
        switch (num) {
            case "2":
                numStr = "twenty";
                break;
            case "3":
                numStr = "thirty";
                break;
            case "4":
                numStr = "forty";
                break;
            case "5":
                numStr = "fifty";
                break;
            case "6":
                numStr = "sixty";
                break;
            case "7":
                numStr = "seventy";
                break;
            case "8":
                numStr = "eighty";
                break;
            case "9":
                numStr = "ninety";
                break;
        }
        return numStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        String numStr;
        String result = null;
        System.out.println("Enter a number: ");
        num = scanner.nextInt();
        int max = 999, min = 0;
        boolean validNum = num >= min && num <= max;
        if (validNum) {
            if (num < 10) {
                numStr = String.valueOf(num);
                result = readNum1(numStr);
            } else if (num < 20) {
                numStr = String.valueOf(num);
                result = readNum2(numStr);
            } else if (num < 100) {
                numStr = String.valueOf(num);
                String tens = String.valueOf(numStr.charAt(0));
                String ones = String.valueOf(numStr.charAt(1));
                if (ones.equals("0")) {
                    result = readNum3(tens);
                } else {
                    result = readNum3(tens) + " " + readNum1(ones);
                }
            } else {
                numStr = String.valueOf(num);
                String hundreds = String.valueOf(numStr.charAt(0));
                String tens = String.valueOf(numStr.charAt(1));
                String ones = String.valueOf(numStr.charAt(2));
                String hundredStr;
                String andStr = "and";
                if (hundreds.equals("1")) {
                    hundredStr = "hundred";
                } else {
                    hundredStr = "hundreds";
                }
                if (ones.equals("0")) {
                    if (tens.equals("0")) {
                        result = readNum1(hundreds) + " " + hundredStr;
                    } else if (tens.equals("1")) {
                        result = readNum1(hundreds) + " " + hundredStr + " " + andStr + " ten";
                    } else {
                        result = readNum1(hundreds) + " " + hundredStr + " " + andStr + " " + readNum3(tens);
                    }
                } else {
                    if (tens.equals("0")) {
                        result = readNum1(hundreds) + " " + hundredStr + " " + andStr + " " + readNum1(ones);
                    } else if (tens.equals("1")) {
                        result = readNum1(hundreds) + " " + hundredStr + " " + andStr + " " + readNum2(tens + ones);
                    } else {
                        result = readNum1(hundreds) + " " + hundredStr + " " + andStr + " " + readNum3(tens) + " " + readNum1(ones);
                    }
                }
            }
        } else {
            System.out.println("Invalid input!");
        }
        System.out.println("Number is read as: " + result);
    }
}