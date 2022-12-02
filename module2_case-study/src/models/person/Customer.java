package models.person;

import java.time.LocalDate;
import java.util.Date;

public class Customer extends Person {
    String address;
    String customerType;

    public Customer() {
    }

    public Customer(String address, String customerType) {
        this.address = address;
        this.customerType = customerType;
    }

    public Customer(String code, String name, LocalDate birthday, boolean gender, int id, int phone, String email, String address, String customerType) {
        super(code, name, birthday, gender, id, phone, email);
        this.address = address;
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getInfo() {
        String[] birthdayArr = String.format("%s", getBirthday()).split("-");
        String birthdayStr = birthdayArr[2] + "/" + birthdayArr[1] + "/" + birthdayArr[0];
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                getPersonCode(), getName(), birthdayStr, isGender(),
                getId(), getPhone(), getEmail(), getAddress(),
                getCustomerType());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + super.getPersonCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthday=" + super.getBirthday() +
                ", gender=" + super.isGender() +
                ", id=" + super.getId() +
                ", phone=" + super.getPhone() +
                ", email='" + super.getEmail() + '\'' +
                "address='" + address + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
