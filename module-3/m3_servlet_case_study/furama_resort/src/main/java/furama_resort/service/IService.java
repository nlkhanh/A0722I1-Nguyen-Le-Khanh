package furama_resort.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    List<T> getAllPagination(int offset, int limit);
    List<T> getSearch(String search);
    List<T> getSearchPagination(String search, int offset, int limit);
}
