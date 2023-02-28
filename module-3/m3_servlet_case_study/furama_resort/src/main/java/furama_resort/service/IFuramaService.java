package furama_resort.service;

import java.sql.SQLException;
import java.util.List;

public interface IFuramaService<S> {
    List<S> getAll(String typeName);
    List<S> getAllPagination(String typeName, int offset, int limit);
    S getLast(String typeName);
    List<S> getSearch(String typeName, String search);
    List<S> getSearchPagination(String typeName, String search, int offset, int limit);
    S getById(String typeName, int id);
    void add(String typeName, S s) throws SQLException;
    void delete(String typeName, int id) throws SQLException;
    void update(String typeName, S s) throws SQLException;

    boolean validateCustomerCode(String customerCode);
    boolean validateServiceCode(String serviceCode);
    boolean validatePhoneNumber(String phoneNumber);
    boolean validateIdCard(String idCard);
    boolean validateEmail(String email);
    boolean validateDate(String date);
    boolean validateInteger(String integerStr);
    boolean validateDouble (String doubleStr);
}
