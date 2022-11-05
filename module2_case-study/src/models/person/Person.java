package models.person;

import java.util.Date;

public abstract class Person {
    private String personCode;
    private String name;
    private Date birthday = new Date();
    private boolean gender;
    private int id;
    private int phone;
    private String email;

    public Person() {
    }

    public Person(String code, String name, Date birthday, boolean gender, int id, int phone, String email) {
        this.personCode = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personCode='" + personCode + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", id=" + id +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
