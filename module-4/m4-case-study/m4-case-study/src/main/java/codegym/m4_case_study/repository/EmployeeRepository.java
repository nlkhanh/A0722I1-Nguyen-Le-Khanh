package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);

    @Query(value = "select * from employee e inner join division d on e.division_id = d.id inner join `position` p on e.position_id = p.id inner join education_degree ed on e.education_degree_id = ed.id where upper(e.name) like concat('%',upper(:search),'%') or upper(e.address) like concat('%',upper(:search),'%') or upper(e.email) like concat('%',upper(:search),'%') or e.id_card like concat('%',:search,'%') or e.phone_number like concat('%',:search,'%') or e.salary  like concat('%',:search,'%') or date_format(e.date_of_birth, '%d/%m/%Y') like concat('%',:search,'%') or upper(d.name) like concat('%',upper(:search),'%') or upper(p.name) like concat('%',upper(:search),'%') or upper(ed.name) like concat('%',upper(:search),'%')",
            countQuery = "select count(*) from employee e inner join division d on e.division_id = d.id inner join `position` p on e.position_id = p.id inner join education_degree ed on e.education_degree_id = ed.id where upper(e.name) like concat('%',upper(:search),'%') or upper(e.address) like concat('%',upper(:search),'%') or upper(e.email) like concat('%',upper(:search),'%') or e.id_card like concat('%',:search,'%') or e.phone_number like concat('%',:search,'%') or e.salary  like concat('%',:search,'%') or date_format(e.date_of_birth, '%d/%m/%Y') like concat('%',:search,'%') or upper(d.name) like concat('%',upper(:search),'%') or upper(p.name) like concat('%',upper(:search),'%') or upper(ed.name) like concat('%',upper(:search),'%')",
            nativeQuery = true)
    Page<Employee> findAllSearch(@Param("search") String search, Pageable pageable);
}