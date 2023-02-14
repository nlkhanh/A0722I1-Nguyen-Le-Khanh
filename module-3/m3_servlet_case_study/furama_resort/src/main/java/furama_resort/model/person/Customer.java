package furama_resort.model.person;

import java.util.Date;

public class Customer extends Person{
    private boolean gender;
    private String customerType;

    public Customer() {
    }

    public Customer(boolean gender, String customerType) {
        this.gender = gender;
        this.customerType = customerType;
    }

    public Customer(int id, String name, Date birthday, String idCard, String phone, String email, String address, boolean gender, String customerType) {
        super(id, name, birthday, idCard, phone, email, address);
        this.gender = gender;
        this.customerType = customerType;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
