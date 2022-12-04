package repository.customer;

import models.person.Customer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\customer.csv";

    @Override
    public void add(Customer customer) {
        List<Customer> customers = read();
        customers.add(customer);
        write(customers);
    }

    @Override
    public void set(Customer customer) {
        List<Customer> customers = read();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonCode().equals(customer.getPersonCode())) {
                customers.set(i, customer);
                break;
            }
        }
    }

    @Override
    public Customer find(String code) {
        List<Customer> customers = read();
        for (Customer customer : customers) {
            if (customer.getPersonCode().equals(code)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        List<Customer> customers = read();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public List<Customer> read() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(SOURCE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArr = line.split(",");
                String code = tempArr[0];
                String name = tempArr[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate birthdate = LocalDate.parse(tempArr[2], formatter);
                boolean gender = tempArr[3].equals("true");
                int id = Integer.parseInt(tempArr[4]);
                int phone = Integer.parseInt(tempArr[5]);
                String email = tempArr[6];
                String address = tempArr[7];
                String customerType = tempArr[8];
                customers.add(new Customer(code, name, birthdate, gender, id, phone, email, address, customerType));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot read your data.");
        }
        return customers;
    }

    @Override
    public void write(List<Customer> customers) {
        try {
            FileWriter fileWriter = new FileWriter(SOURCE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customers) {
                bufferedWriter.write(customer.getInfo() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot write your data.");
        }
    }
}
