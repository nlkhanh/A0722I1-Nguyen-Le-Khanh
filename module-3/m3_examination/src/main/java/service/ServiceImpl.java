package service;

import model.Department;
import repository.IRepository;
import repository.RepositoryImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements IService{
    private final String CODE_PATTERN = "[A-Z0-9]{3}\\-[A-Z0-9]{2}\\-[A-Z0-9]{2}";

    private final String DATE_PATTERN = "dd/MM/yyyy";


    private IRepository repository = new RepositoryImpl();


    @Override
    public List<Department> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Department> getSearch(String type, int floor, Date startDate, Date endDate) {
        return repository.getSearch(type, floor, startDate, endDate);
    }

    @Override
    public Department getById(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean isExistCode(int id) {
        return repository.isExistCode(id);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public void insert(Department department) throws SQLException {
        repository.insert(department);
    }

    @Override
    public void update(Department department) throws SQLException {
        repository.update(department);
    }
}
