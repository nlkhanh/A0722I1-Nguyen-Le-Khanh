package repository.employee;

import models.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\employee.csv";

    @Override
    public void set(Employee employee) {
        List<Employee> employees = readCSV();
        if (employees != null) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getPersonCode().equals(employee.getPersonCode())) {
                    employees.set(i, employee);
                    break;
                }
            }
        } else {
            System.out.println("Your list is null!");
        }
    }

    @Override
    public void displayAll() {
        List<Employee> employees = readCSV();
        if (employees != null) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Override
    public Employee find(String code) {
        List<Employee> employees = readCSV();
        if (employees != null) {
            for (Employee employee : employees) {
                if (employee.getPersonCode().equals(code)) {
                    return employee;
                }
            }
        }
        return null;
    }

    @Override
    public void add(Employee employee) {
        List<Employee> employees = readCSV();
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
        writeCSV(employees);
    }

    @Override
    public void remove() {

    }

    @Override
    public void add() {

    }

    @Override
    public void set() {

    }

    @Override
    public List<Employee> readCSV() {
        try {
            List<Employee> employees = new ArrayList<>();
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
                int salary = Integer.parseInt(tempArr[7]);
                String professional = tempArr[8];
                String position = tempArr[9];
                employees.add(new Employee(code, name, birthdate, gender, id, phone, email, salary, professional, position));
            }
            bufferedReader.close();
            fileReader.close();
            return employees;
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot read your data.");
            return null;
        }
    }

    @Override
    public void writeCSV(List<Employee> employees) {
        try {
            FileWriter fileWriter = new FileWriter(SOURCE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employees) {
                bufferedWriter.write(employee.getInfo() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot write your data.");
        }
    }
}
