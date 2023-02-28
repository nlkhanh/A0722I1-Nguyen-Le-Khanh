package util;

import model.BankAccount;
import model.PayingAccount;
import model.SaveAccount;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {
    private static final String FILE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_examination\\src\\data\\bank_account.csv";

    public static List<BankAccount> read() throws IOException, DateTimeParseException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<BankAccount> bankAccounts = new ArrayList<>();
        try {
            fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            while ((line = bufferedReader.readLine()) != null) {
                String[] bankAccountArr = line.split(",");
                if (bankAccountArr.length == 8) {
                    bankAccounts.add(new SaveAccount((Integer.parseInt(bankAccountArr[0])), bankAccountArr[1],
                            bankAccountArr[2], LocalDate.parse(bankAccountArr[3], formatter), Integer.parseInt(bankAccountArr[4]),
                            LocalDate.parse(bankAccountArr[5], formatter), Double.parseDouble(bankAccountArr[6]), Integer.parseInt(bankAccountArr[7])));
                } else {
                    bankAccounts.add(new PayingAccount((Integer.parseInt(bankAccountArr[0])), bankAccountArr[1],
                            bankAccountArr[2], LocalDate.parse(bankAccountArr[3], formatter), bankAccountArr[4],
                            Integer.parseInt(bankAccountArr[5])));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        return bankAccounts;
    }

    public static void write(List<BankAccount> bankAccounts) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (BankAccount bankAccount : bankAccounts) {
                bufferedWriter.write(bankAccount.getInfo() + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
