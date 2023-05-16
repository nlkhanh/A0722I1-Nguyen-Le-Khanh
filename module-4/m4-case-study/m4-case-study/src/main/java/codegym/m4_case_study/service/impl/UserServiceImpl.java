package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.User;
import codegym.m4_case_study.repository.UserRepository;
import codegym.m4_case_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String username) {
        userRepository.deleteById(username);
    }
}
