package models.person;

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

    public Customer(String code, String name, Date birthday, boolean gender, int id, int phone, String email, String address, String customerType) {
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
