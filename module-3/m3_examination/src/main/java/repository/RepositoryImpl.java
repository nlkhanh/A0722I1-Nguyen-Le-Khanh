package repository;

import model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements IRepository {
    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("{CALL get_all()}");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String code = resultSet.getString("code");
                    double area = resultSet.getDouble("area");
                    String status = resultSet.getString("status");
                    int floor = resultSet.getInt("floor");
                    String type = resultSet.getString("type");
                    String detail = resultSet.getString("detail");
                    double cost = resultSet.getDouble("cost");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    departments.add(new Department(id, code, area, status, floor, type, detail, cost, startDate, endDate));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return departments;
    }

    @Override
    public List<Department> getSearch(String type_in, int floor_in, Date startDate_in, Date endDate_in) {
        List<Department> departments = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("{CALL get_search(?, ?, ?, ?)}");
                statement.setString(1, type_in);
                statement.setInt(2, floor_in);
                statement.setDate(3, startDate_in);
                statement.setDate(4, endDate_in);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String code = resultSet.getString("code");
                    double area = resultSet.getDouble("area");
                    String status = resultSet.getString("status");
                    int floor = resultSet.getInt("floor");
                    String type = resultSet.getString("type");
                    String detail = resultSet.getString("detail");
                    double cost = resultSet.getDouble("cost");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    departments.add(new Department(id, code, area, status, floor, type, detail, cost, startDate, endDate));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return departments;
    }

    @Override
    public Department getById(int id_in) {
        Department department = null;
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("{CALL get_by_id(?)}");
                statement.setInt(1, id_in);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String code = resultSet.getString("code");
                    double area = resultSet.getDouble("area");
                    String status = resultSet.getString("status");
                    int floor = resultSet.getInt("floor");
                    String type = resultSet.getString("type");
                    String detail = resultSet.getString("detail");
                    double cost = resultSet.getDouble("cost");
                    Date startDate = resultSet.getDate("start_date");
                    Date endDate = resultSet.getDate("end_date");
                    department = new Department(id, code, area, status, floor, type, detail, cost, startDate, endDate);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return department;
    }

    @Override
    public boolean isExistCode(int id_id) {
        boolean check = false;
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("{CALL get_by_id(?)}");
                statement.setInt(1, id_id);
                resultSet = statement.executeQuery();
                int id = 0;
                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
                if (id != 0) {
                    check = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return check;
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = connection.prepareCall("{CALL delete_department(?)}");
        if (connection != null) {
            try {
                statement.setInt(1, id);
                statement.executeUpdate();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void insert(Department department) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = connection.prepareCall("{CALL insert_department(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        if (connection != null) {
            try {
                statement.setString(1, department.getCode());
                statement.setDouble(2, department.getArea());
                statement.setString(3, department.getStatus());
                statement.setInt(4, department.getFloor());
                statement.setString(5, department.getType());
                statement.setString(6, department.getDetail());
                statement.setDouble(7, department.getCost());
                statement.setDate(8, department.getStartDate());
                statement.setDate(9, department.getEndDate());
                statement.executeUpdate();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void update(Department department) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = connection.prepareCall("{CALL update_department(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        if (connection != null) {
            try {
                statement.setString(1, department.getCode());
                statement.setDouble(2, department.getArea());
                statement.setString(3, department.getStatus());
                statement.setInt(4, department.getFloor());
                statement.setString(5, department.getType());
                statement.setString(6, department.getDetail());
                statement.setDouble(7, department.getCost());
                statement.setDate(8, department.getStartDate());
                statement.setDate(9, department.getEndDate());
                statement.setInt(10, department.getId());
                statement.executeUpdate();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
