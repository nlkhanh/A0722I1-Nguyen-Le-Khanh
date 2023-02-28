package furama_resort.service;

import com.Validate;
import furama_resort.repository.FuramaRepositoryImpl;
import furama_resort.repository.IFuramaRepository;

import java.sql.SQLException;
import java.util.List;

public class FuramaServiceImpl<S> implements IFuramaService<S>{
    private final IFuramaRepository<S> FURAMA_REPOSITORY = new FuramaRepositoryImpl<>();


    @Override
    public List<S> getAll(String typeName) {
        return FURAMA_REPOSITORY.getAll(typeName);
    }

    @Override
    public List<S> getAllPagination(String typeName, int offset, int limit) {
        return FURAMA_REPOSITORY.getAllPagination(typeName, offset, limit);
    }

    @Override
    public S getLast(String typeName) {
        return FURAMA_REPOSITORY.getLast(typeName);
    }

    @Override
    public List<S> getSearch(String typeName, String search) {
        return FURAMA_REPOSITORY.getSearch(typeName, search);
    }

    @Override
    public List<S> getSearchPagination(String typeName, String search, int offset, int limit) {
        return FURAMA_REPOSITORY.getSearchPagination(typeName, search, offset, limit);
    }

    @Override
    public S getById(String typeName, int id) {
        return FURAMA_REPOSITORY.getById(typeName, id);
    }

    @Override
    public void add(String typeName, S s) throws SQLException {
        FURAMA_REPOSITORY.add(typeName, s);
    }

    @Override
    public void delete(String typeName, int id) throws SQLException {
        FURAMA_REPOSITORY.delete(typeName, id);
    }

    @Override
    public void update(String typeName, S s) throws SQLException {
        FURAMA_REPOSITORY.update(typeName, s);
    }

    @Override
    public boolean validateCustomerCode(String customerCode) {
        return Validate.isCustomerCodeRight(customerCode);
    }

    @Override
    public boolean validateServiceCode(String serviceCode) {
        return Validate.isServiceCodeRight(serviceCode);
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        return Validate.isPhoneNumberRight(phoneNumber);
    }

    @Override
    public boolean validateIdCard(String idCard) {
        return Validate.isIdCardRight(idCard);
    }

    @Override
    public boolean validateEmail(String email) {
        return Validate.isEmailRight(email);
    }

    @Override
    public boolean validateDate(String date) {
        return Validate.isDateRight(date);
    }

    @Override
    public boolean validateInteger(String integerStr) {
        return Validate.isIntegerPositiveRight(integerStr);
    }

    @Override
    public boolean validateDouble(String doubleStr) {
        return Validate.isDoublePositiveRight(doubleStr);
    }
}
