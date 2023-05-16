package codegym.m4_case_study.repository;

import codegym.m4_case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}