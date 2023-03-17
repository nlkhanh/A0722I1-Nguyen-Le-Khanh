package codegym.repository.impl;

import codegym.model.Customer;
import codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {
       entityManager.persist(customer);
       return customer;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        for (int i = 0; i <= customers.size(); i++) {
            entityManager.persist(customers.get(i));
        }
        return customers;
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public boolean exists(Long id) {
        return entityManager.contains(findOne(id));
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        List<Customer> customers = new ArrayList<>();
        for (Long id : ids) {
            customers.add(findOne(id));
        }
        return customers;
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        for (Customer customer : customers) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void deleteAll() {
        List<Customer> customers = findAll();
        for (Customer customer : customers) {
            entityManager.remove(customer);
        }
    }
}
