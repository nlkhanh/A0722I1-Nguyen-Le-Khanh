package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private static final IUserRepository USER_REPOSITORY = new UserRepositoryImpl();
    @Override
    public void insertUser(User user) throws SQLException {
        USER_REPOSITORY.insertUser(user);
    }

    @Override
    public void insertUserStore(User user) {
        USER_REPOSITORY.insertUserStore(user);
    }

    @Override
    public User selectUser(int id) {
        return USER_REPOSITORY.selectUser(id);
    }

    @Override
    public User getUserById(int id) {
        return USER_REPOSITORY.getUserById(id);
    }

    @Override
    public List<User> getUsersByCountry(String country) {
        return USER_REPOSITORY.getUsersByCountry(country);
    }

    public List<User> getUsersByCountryPagination(String country, int offset, int limit) {
        return USER_REPOSITORY.getUsersByCountryPagination(country, offset, limit);
    }

    @Override
    public List<User> selectAllUsers() {
        return USER_REPOSITORY.selectAllUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return USER_REPOSITORY.getAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return USER_REPOSITORY.deleteUser(id);
    }

    @Override
    public boolean deleteUserStore(int id) throws SQLException {
        return USER_REPOSITORY.deleteUserStore(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return USER_REPOSITORY.updateUser(user);
    }

    @Override
    public boolean updateUserStore(User user) throws SQLException {
        return USER_REPOSITORY.updateUserStore(user);
    }

    @Override
    public List<User> selectUserByName(String searchName) {
        return USER_REPOSITORY.selectUserByName(searchName);
    }

    @Override
    public List<User> getUsersSortNamePagination(int offset, int limit) {
        List<User> users = USER_REPOSITORY.getUsersSortNamePagination(offset, limit);
        return users;
    }

    @Override
    public List<User> getUsersByCountrySortNamePagination(String country, int offset, int limit) {
        List<User> users = USER_REPOSITORY.getUsersByCountrySortNamePagination(country, offset, limit);
        return users;
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
           USER_REPOSITORY.addUserTransaction(user, permissions);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        USER_REPOSITORY.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        USER_REPOSITORY.insertUpdateUseTransaction();
    }

    @Override
    public List<User> getAllUsersPagination(int offset, int limit) {
        return USER_REPOSITORY.getAllUsersPagination(offset, limit);
    }
}
