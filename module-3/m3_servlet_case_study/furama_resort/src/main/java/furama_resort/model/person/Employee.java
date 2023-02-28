package furama_resort.model.person;

import java.sql.Date;

public class Employee extends Person{
    private double salary;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;
    private String username;

    public Employee() {
    }

    public Employee(double salary, int positionId, int educationDegreeId, int divisionId, String username) {
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(int id, String name, Date birthday, boolean gender, String idCard, String phone, String email, String address, double salary, int positionId, int educationDegreeId, int divisionId, String username) {
        super(id, name, birthday, gender, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(String name, Date birthday, boolean gender, String idCard, String phone, String email, String address, double salary, int positionId, int educationDegreeId, int divisionId, String username) {
        super(name, birthday, gender, idCard, phone, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
