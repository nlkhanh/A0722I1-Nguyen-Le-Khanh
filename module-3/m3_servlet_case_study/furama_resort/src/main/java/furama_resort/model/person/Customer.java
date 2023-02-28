package furama_resort.model.person;

import java.sql.Date;

public class Customer extends Person{
    private int customerTypeId;

    public Customer() {
    }

    public Customer(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public Customer(int id, String name, Date birthday, boolean gender, String idCard, String phone, String email, String address, int customerTypeId) {
        super(id, name, birthday, gender, idCard, phone, email, address);
        this.customerTypeId = customerTypeId;
    }

    public Customer(String name, Date birthday, boolean gender, String idCard, String phone, String email, String address, int customerTypeId) {
        super(name, birthday, gender, idCard, phone, email, address);
        this.customerTypeId = customerTypeId;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
