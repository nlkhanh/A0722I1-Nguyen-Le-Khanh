package com;

import furama_resort.model.User;
import furama_resort.model.UserRole;
import furama_resort.model.person.Employee;
import furama_resort.service.FuramaServiceImpl;
import furama_resort.service.IFuramaService;

import java.sql.SQLException;
import java.util.List;

public class UserManager {
    private static final IFuramaService<User> FURAMA_SERVICE_USER = new FuramaServiceImpl<>();
    private static final IFuramaService<UserRole> FURAMA_SERVICE_USER_ROLE = new FuramaServiceImpl<>();

    public static boolean addUser(User user) throws SQLException {
        if (isUserExist(user)){
            return false;
        }
        FURAMA_SERVICE_USER.add("user", user);
        return true;
    }

    public static boolean updateUserPassword(User user) throws SQLException {
        if (isUserExist(user)) {
            FURAMA_SERVICE_USER.update("user_password", user);
            return true;
        }
        return false;
    }

    public static void addUserRole(Employee employee) throws SQLException {
        if (employee.getPositionId() >= 5) {
            FURAMA_SERVICE_USER_ROLE.add("user_role", new UserRole(employee.getUsername(), 2));
        } else {
            FURAMA_SERVICE_USER_ROLE.add("user_role", new UserRole(employee.getUsername(), 1));
        }
    }

    public static void updateUserRole(Employee employee) throws SQLException {
        if (employee.getPositionId() >= 5) {
            FURAMA_SERVICE_USER_ROLE.update("user_role", new UserRole(employee.getUsername(), 2));
        } else {
            FURAMA_SERVICE_USER_ROLE.update("user_role", new UserRole(employee.getUsername(), 1));
        }
    }

    private static boolean isUserExist(User user) {
        List<User> users = FURAMA_SERVICE_USER.getAll("user");
        if (users.size() > 0) {
            for (User userItem : users) {
                if (userItem.getUsername().equals(user.getUsername())) {
                    return true;
                }
            }
        }
        return false;
    }
}
