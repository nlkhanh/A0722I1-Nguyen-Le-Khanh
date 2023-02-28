package m2s1_introduction_java.m2s1_review;

import java.util.Scanner;

public class NumberReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter a number (0-999): ");
            number = input.nextInt();
        } while ((number < 0) || (number > 999));
        int hundred = number / 100;
        int ten = (number - (hundred * 100)) / 10;
        int one = number - (hundred * 100) - (ten * 10);
        String letters = " ";
        switch (hundred) {
            case 1:
                letters += "One hundred";
                break;
            case 2:
                letters += "Two hundreds";
                break;
            case 3:
                letters += "Three hundreds";
                break;
            case 4:
                letters += "Four hundreds";
                break;
            case 5:
                letters += "Five hundreds";
                break;
            case 6:
                letters += "Six hundreds";
                break;
            case 7:
                letters += "Seven hundreds";
                break;
            case 8:
                letters += "Eight hundreds";
                break;
            case 9:
                letters += "Nine hundreds";
                break;
        }
        if ((hundred != 0) && ((ten != 0) || (one != 0))) {
            letters += " and ";
        }
        switch (ten) {
            case 1:
                switch (one) {
                    case 1:
                        letters += "Eleven";
                        break;
                    case 2:
                        letters += "Twelve";
                        break;
                    case 3:
                        letters += "Thirteen";
                        break;
                    case 4:
                        letters += "Fourteen";
                        break;
                    case 5:
                        letters += "Fifteen";
                        break;
                    case 6:
                        letters += "Sixteen";
                        break;
                    case 7:
                        letters += "Seventeen";
                        break;
                    case 8:
                        letters += "Eighteen";
                        break;
                    case 9:
                        letters += "Nineteen";
                        break;
                }
                break;
            case 2:
                letters += "Twenty";
                break;
            case 3:
                letters += "Thirty";
                break;
            case 4:
                letters += "Forty";
                break;
            case 5:
                letters += "Fifty";
                break;
            case 6:
                letters += "Sixty";
                break;
            case 7:
                letters += "Seventy";
                break;
            case 8:
                letters += "Eighty";
                break;
            case 9:
                letters += "Ninety";
                break;
        }
        if (ten != 1) {
            letters += " ";
            switch (one) {
                case 0:
                    if ((hundred == 0) && (ten == 0)) {
                        letters += "Zero";
                    }
                    break;
                case 1:
                    letters += "One";
                    break;
                case 2:
                    letters += "Two";
                    break;
                case 3:
                    letters += "Three";
                    break;
                case 4:
                    letters += "Four";
                    break;
                case 5:
                    letters += "Five";
                    break;
                case 6:
                    letters += "Six";
                    break;
                case 7:
                    letters += "Seven";
                    break;
                case 8:
                    letters += "Eight";
                    break;
                case 9:
                    letters += "Nine";
                    break;
            }
        }
        System.out.println(number + " is read as:" + letters);
    }
}