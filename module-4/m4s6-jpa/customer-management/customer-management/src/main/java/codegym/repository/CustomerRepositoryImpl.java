package codegym.repository;

import codegym.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer= findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        entityManager.createNativeQuery("CALL insert_customer(:firstName, :lastName)")
                .setParameter("firstName", customer.getFirstName())
                .setParameter("lastName", customer.getLastName())
                .executeUpdate();
    }
}
