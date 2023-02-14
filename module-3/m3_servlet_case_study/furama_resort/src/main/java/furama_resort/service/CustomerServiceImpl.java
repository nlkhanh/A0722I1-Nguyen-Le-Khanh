package furama_resort.service;

import furama_resort.model.person.Customer;
import furama_resort.repository.CustomerRepositoryImpl;
import furama_resort.repository.IRepository;

import java.util.List;

public class CustomerServiceImpl implements IService<Customer>{
    private static final IRepository<Customer> CUSTOMER_REPOSITORY = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAll() {
        return CUSTOMER_REPOSITORY.getAll();
    }

    @Override
    public List<Customer> getAllPagination(int offset, int limit) {
        return CUSTOMER_REPOSITORY.getAllPagination(offset, limit);
    }

    @Override
    public List<Customer> getSearch(String search) {
        return CUSTOMER_REPOSITORY.getSearch(search);
    }

    @Override
    public List<Customer> getSearchPagination(String search, int offset, int limit) {
        return CUSTOMER_REPOSITORY.getSearchPagination(search, offset, limit);
    }
}
