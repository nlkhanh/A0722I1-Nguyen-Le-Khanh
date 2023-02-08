package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private static final IUserRepository USER_REPOSITORY = new UserRepositoryImpl();
    @Override
    public void insertUser(User user) throws SQLException {
        USER_REPOSITORY.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return USER_REPOSITORY.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return USER_REPOSITORY.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return USER_REPOSITORY.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return USER_REPOSITORY.updateUser(user);
    }

    @Override
    public List<User> selectUserByName(String searchName) {
        return USER_REPOSITORY.selectUserByName(searchName);
    }

    @Override
    public List<User> selectAllUsersSortByName() {
        List<User> users = USER_REPOSITORY.selectAllUsers();
        Collections.sort(users);
        return users;
    }
}
