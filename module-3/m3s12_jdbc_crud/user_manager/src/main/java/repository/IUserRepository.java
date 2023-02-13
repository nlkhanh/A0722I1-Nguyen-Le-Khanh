package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user);
    void insertUserStore(User user);
    User selectUser(int id);
    User getUserById(int id);
    List<User> getUsersByCountry(String country);
    List<User> getUsersByCountryPagination(String country, int offset, int limit);
    List<User> selectAllUsers();
    List<User> getAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean deleteUserStore(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean updateUserStore(User user) throws SQLException;
    List<User> selectUserByName(String searchName);
    void addUserTransaction(User user, int[] permissions);
    void insertUpdateWithoutTransaction();
    void insertUpdateUseTransaction();
    List<User> getAllUsersPagination(int offset, int limit);
    List<User> getUsersSortNamePagination(int offset, int limit);
    List<User> getUsersByCountrySortNamePagination(String country, int offset, int limit);
}
