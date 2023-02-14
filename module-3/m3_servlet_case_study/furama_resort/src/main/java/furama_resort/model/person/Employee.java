package furama_resort.model.person;

import java.util.Date;

public class Employee extends Person{
    private String educationDegree;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String educationDegree, String position, double salary) {
        this.educationDegree = educationDegree;
        this.position = position;
        this.salary = salary;
    }

    public Employee(int id, String name, Date birthday, String idCard, String phone, String email, String address, String educationDegree, String position, double salary) {
        super(id, name, birthday, idCard, phone, email, address);
        this.educationDegree = educationDegree;
        this.position = position;
        this.salary = salary;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
