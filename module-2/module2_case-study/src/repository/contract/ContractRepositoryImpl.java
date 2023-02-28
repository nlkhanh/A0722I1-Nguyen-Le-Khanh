package repository.contract;

import models.booking.Contract;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ContractRepositoryImpl implements ContractRepository {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\contract.csv";

    @Override
    public void add(Contract e) {
        Set<Contract> contracts = read();
        contracts.add(e);
        write(contracts);
    }

    @Override
    public void set(Contract e) {
        add(e);
    }

    @Override
    public Contract find(String code) {
        Set<Contract> contracts = read();
        for (Contract contract : contracts) {
            if (contract.getContractNumber().equals(code)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        Set<Contract> contracts = read();
        if (contracts.size() == 0) {
            System.out.println("There are not contract in repository");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    @Override
    public Set<Contract> read() {
        LinkedHashSet<Contract> contracts = new LinkedHashSet<>();
        try {
            FileReader fileReader = new FileReader(SOURCE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArr = line.split(",");
                String contractNumber = tempArr[0];
                String bookingCode = tempArr[1];
                double deposits = Double.parseDouble(tempArr[2]);
                double totalBill = Double.parseDouble(tempArr[3]);
                String customerCode = tempArr[4];
                contracts.add(new Contract(contractNumber, bookingCode, deposits, totalBill, customerCode));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot read your data.");
        }
        return contracts;
    }

    @Override
    public void write(Set<Contract> contracts) {
        try {
            FileWriter fileWriter = new FileWriter(SOURCE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract : contracts) {
                bufferedWriter.write(contract.getInfo() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot write your data.");
        }
    }
}
