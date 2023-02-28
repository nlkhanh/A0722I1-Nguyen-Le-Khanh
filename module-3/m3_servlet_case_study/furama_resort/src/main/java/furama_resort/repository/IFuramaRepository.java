package furama_resort.repository;

import java.sql.SQLException;
import java.util.List;

public interface IFuramaRepository<R> {
    List<R> getAll(String typeName);
    List<R> getAllPagination(String typeName, int offset, int limit);
    R getLast(String typeName);
    List<R> getSearch(String typeName, String search);
    List<R> getSearchPagination(String typeName, String search, int offset, int limit);
    R getById(String typeName, int id);
    void add(String typeName, R r) throws SQLException;
    void delete(String typeName, int id) throws SQLException;
    void update(String typeName, R r) throws SQLException;
}
