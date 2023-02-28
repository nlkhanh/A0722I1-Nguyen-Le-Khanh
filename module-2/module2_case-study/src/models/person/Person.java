package models.person;

import java.time.LocalDate;

public abstract class Person {
    private String personCode;
    private String name;
    private LocalDate birthday;
    private boolean gender;
    private int id;
    private int phone;
    private String email;

    public Person() {
    }

    public Person(String code, String name, LocalDate birthday, boolean gender, int id, int phone, String email) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        String[] birthdayArr = String.format("%s", getBirthday()).split("-");
        return birthdayArr[2] + "/" + birthdayArr[1] + "/" + birthdayArr[0];
    }

    public boolean isMale() {
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

    public abstract String getInfo();
}
