package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements ICustomerRepository{
    private static final Map<Integer, Customer> CUSTOMER_LIST = new HashMap<>();

    static {
        CUSTOMER_LIST.put(1, new Customer(1, "Nguyen Van A", "ngvana@gmail.com", "Ha Noi"));
        CUSTOMER_LIST.put(2, new Customer(2, "Nguyen Thi B", "ngthib@gmail.com", "Da Nang"));
        CUSTOMER_LIST.put(3, new Customer(3, "Nguyen Van C", "ngvanc@gmail.com", "Hai Phong"));
        CUSTOMER_LIST.put(4, new Customer(4, "Nguyen Thi D", "ngthid@gmail.com", "Quang Nam"));
        CUSTOMER_LIST.put(5, new Customer(5, "Nguyen Van E", "ngvane@gmail.com", "Ca Mau"));
        CUSTOMER_LIST.put(6, new Customer(6, "Nguyen Van F", "ngvanf@gmail.com", "Tra Vinh"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(CUSTOMER_LIST.values());
    }

    @Override
    public void save(Customer customer) {
        CUSTOMER_LIST.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return CUSTOMER_LIST.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        CUSTOMER_LIST.put(id, customer);
    }

    @Override
    public void remove(int id) {
        CUSTOMER_LIST.remove(id);
    }
}
