package repository;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private static final String INSERT_USERS_SQL = "insert into users(name, email, country) values (?,?,?)";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SELECT_USER_BY_NAME = "select id,name,email,country from users where name = ?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE employee"
            + "("
            + "id serial,"
            + "`name` varchar(100) not null,"
            + "salary numeric(15, 2),"
            + "create_date timestamp,"
            + "primary key (id)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS employee";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (`name`, salary, create_date) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET salary=? WHERE `name`=?";

    public UserRepositoryImpl() {
    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insertUserStore(User user) {
        String qry = "{call insert_user(?, ?, ?)}";
        try (Connection connection = DBConnection.getConnection(); CallableStatement callableStatement = connection.prepareCall(qry);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String qry = "{call get_user_by_id(?)}";
        try (Connection connection = DBConnection.getConnection(); CallableStatement callableStatement = connection.prepareCall(qry);) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> getUsersByCountry(String countrySearch) {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_users_by_country(?)}");
                cStmt.setString(1, countrySearch);
                resultSet = cStmt.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    @Override
    public List<User> getUsersByCountryPagination(String countrySearch, int offset, int limit) {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_users_by_country_pagination(?, ?, ?)}");
                cStmt.setString(1, countrySearch);
                cStmt.setInt(2, offset);
                cStmt.setInt(3, limit);
                resultSet = cStmt.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                CallableStatement cStmt = connection.prepareCall("{CALL get_all_users()}");
                ) {
            ResultSet resultSet = cStmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean deleteUserStore(int id) throws SQLException {
        boolean rowDeleted;
        String qry = "{CALL delete_user(?)}";
        try (Connection connection = DBConnection.getConnection();
            CallableStatement cStmt = connection.prepareCall(qry);
        ) {
            cStmt.setInt(1, id);
            rowDeleted = cStmt.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateUserStore(User user) throws SQLException {
        boolean rowUpdated;
        String qry = "{CALL update_user(?,?,?,?)}";
        try (Connection connection = DBConnection.getConnection();
            CallableStatement callStmt = connection.prepareCall(qry);
        ) {
            callStmt.setInt(1, user.getId());
            callStmt.setString(2, user.getName());
            callStmt.setString(3, user.getEmail());
            callStmt.setString(4, user.getCountry());
            rowUpdated = callStmt.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> selectUserByName(String searchName) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME)) {
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementAssignment = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false);
            String qry = "insert into users(id, name, email, country) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAffected = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int userId = 0;
            if (resultSet.next()) {
                userId = resultSet.getInt(1);

            }
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permission(user_id, permission_id) VALUES (?, ?)";
                preparedStatementAssignment = connection.prepareStatement(sqlPivot);
                for (int permission : permissions) {
                    preparedStatementAssignment.setInt(1, userId);
                    preparedStatementAssignment.setInt(2, permission);
                    preparedStatementAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            ex.getMessage();
        } finally {
            try {
                if (resultSet != null) {resultSet.close();}
                if (preparedStatementAssignment != null) {preparedStatementAssignment.close();}
                if (preparedStatement != null) {preparedStatement.close();}
                if (connection != null) {connection.close();}
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
                PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
                PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
                ) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

//          Check error
            psUpdate.setBigDecimal(2, new BigDecimal(999.9));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
        ) {
            stmt.execute(SQL_TABLE_DROP);
            stmt.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);

            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

//          Check error
            psUpdate.setBigDecimal(1, new BigDecimal(999.9));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsersPagination(int offset, int limit) {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_users_pagination(?, ?)}");
                cStmt.setInt(1, offset);
                cStmt.setInt(2, limit);
                resultSet = cStmt.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    @Override
    public List<User> getUsersSortNamePagination(int offset, int limit) {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_users_sort_name_pagination(?, ?)}");
                cStmt.setInt(1, offset);
                cStmt.setInt(2, limit);
                resultSet = cStmt.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    @Override
    public List<User> getUsersByCountrySortNamePagination(String countrySearch, int offset, int limit) {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_users_by_country_sort_name_pagination(?, ?, ?)}");
                cStmt.setString(1, countrySearch);
                cStmt.setInt(2, offset);
                cStmt.setInt(3, limit);
                resultSet = cStmt.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users.add(new User(id, name, email, country));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof  SQLException) {
                e.printStackTrace();
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
