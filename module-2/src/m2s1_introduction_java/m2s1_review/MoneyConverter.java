package m2s1_introduction_java.m2s1_review;

import java.util.Scanner;

public class MoneyConverter {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your USD: ");
        double usd = input.nextDouble();
        double vnd = usd * rate;
        System.out.println(usd + " USD = " + vnd + " VND");
    }
}