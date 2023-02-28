package service;

import model.Department;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IService {
    List<Department> getAll();

    List<Department> getSearch(String type, int floor, Date startDate, Date endDate);

    Department getById(int id);
    boolean isExistCode(int id);


    void delete(int id) throws SQLException;

    void insert(Department department) throws SQLException;
    void update(Department department)  throws SQLException;
}
