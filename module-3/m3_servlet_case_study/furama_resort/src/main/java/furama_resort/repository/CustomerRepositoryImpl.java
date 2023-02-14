package furama_resort.repository;

import furama_resort.model.person.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements IRepository<Customer> {
    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_all_customers()}");
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    customers.add(getCustomer(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getAllPagination(int offset, int limit) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_all_customers_pagination(?, ?)}");
                cStmt.setInt(1, offset);
                cStmt.setInt(2, limit);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    customers.add(getCustomer(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getSearch(String search) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_search_customers(?)}");
                cStmt.setString(1, search);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    customers.add(getCustomer(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customers;
    }

    @Override
    public List<Customer> getSearchPagination(String search, int offset, int limit) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_search_customers_pagination(?, ?, ?)}");
                cStmt.setString(1, search);
                cStmt.setInt(2, offset);
                cStmt.setInt(3, limit);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    customers.add(getCustomer(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customers;
    }

    private Customer getCustomer(ResultSet rs) throws SQLException {
        int id = rs.getInt("c_id");
        String name = rs.getString("c_name");
        Date birthday = rs.getDate("c_birthday");
        String idCard = rs.getString("c_id_card");
        String phone = rs.getString("c_phone");
        String email = rs.getString("c_email");
        String address = rs.getString("c_address");
        boolean gender = rs.getBoolean("c_gender");
        String customerType = rs.getString("c_type_name");

        return new Customer(id, name, birthday, idCard, phone, email, address, gender, customerType);
    }
}
