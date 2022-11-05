package models.person;

import java.util.Date;

public class Employee extends Person{
    private int salary;
    private String professional;
    private String position;

    public Employee() {}

    public Employee(int salary, String professional, String position) {
        this.salary = salary;
        this.professional = professional;
        this.position = position;
    }

    public Employee(String code, String name, Date birthday, boolean gender, int id, int phone, String email, int salary, String professional, String position) {
        super(code, name, birthday, gender, id, phone, email);
        this.salary = salary;
        this.professional = professional;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code='" + super.getPersonCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthday=" + super.getBirthday() +
                ", gender=" + super.isGender() +
                ", id=" + super.getId() +
                ", phone=" + super.getPhone() +
                ", email='" + super.getEmail() + '\'' +
                ", salary=" + salary +
                ", professional='" + professional + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
