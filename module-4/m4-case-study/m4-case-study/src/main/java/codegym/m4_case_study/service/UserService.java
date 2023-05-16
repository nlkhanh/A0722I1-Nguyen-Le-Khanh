package codegym.m4_case_study.service;

import codegym.m4_case_study.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String username);
    User save (User user);
    void deleteById(String username);
}
