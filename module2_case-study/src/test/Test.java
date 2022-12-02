package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ngày: ");
        String dateStr = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        FileWriter fileWriter = new FileWriter("E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\test\\test.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String dateWrite = String.format("%s", date);
        String[] dateWriteList = dateWrite.split("-");
        dateWrite = dateWriteList[2] + "/" + dateWriteList[1] + "/" + dateWriteList[0];
        bufferedWriter.write(dateWrite);
        bufferedWriter.close();
        fileWriter.close();
    }
}
