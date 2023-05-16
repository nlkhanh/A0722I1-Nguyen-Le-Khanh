package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteAllByIdIn(List<Long> deleteIds);
}