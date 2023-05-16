package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);

    @Query(value = "select * from customer c inner join customer_type ct on c.customer_type_id = ct.id where upper(c.name) like concat('%',upper(:search),'%') or upper(c.address) like concat('%',upper(:search),'%') or upper(c.email) like concat('%',upper(:search),'%') or c.id_card like concat('%',:search,'%') or c.phone_number like concat('%',:search,'%') or upper(ct.name) like concat('%',upper(:search),'%') or date_format(c.date_of_birth, '%d/%m/%Y') like concat('%',:search,'%') or upper(c.gender) like concat('%',:search,'%')",
            countQuery = "select count(*) from customer c inner join customer_type ct on c.customer_type_id = ct.id where upper(c.name) like concat('%',upper(:search),'%') or upper(c.address) like concat('%',upper(:search),'%') or upper(c.email) like concat('%',upper(:search),'%') or c.id_card like concat('%',:search,'%') or c.phone_number like concat('%',:search,'%') or upper(ct.name) like concat('%',upper(:search),'%') or date_format(c.date_of_birth, '%d/%m/%Y') like concat('%',:search,'%') or upper(c.gender) like concat('%',:search,'%')",
            nativeQuery = true)
    Page<Customer> findAllSearch(@Param("search") String search, Pageable pageable);
}