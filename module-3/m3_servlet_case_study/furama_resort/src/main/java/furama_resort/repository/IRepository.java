package furama_resort.repository;

import furama_resort.model.person.Customer;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    List<T> getAllPagination(int offset, int limit);
    List<T> getSearch(String search);
    List<T> getSearchPagination(String search, int offset, int limit);
}
