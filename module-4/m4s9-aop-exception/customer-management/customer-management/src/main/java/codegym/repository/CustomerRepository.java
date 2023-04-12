package codegym.repository;

import codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAllByNameContainingOrEmailContainingOrAddressContaining(String name, String email, String address, Pageable pageable);
}
