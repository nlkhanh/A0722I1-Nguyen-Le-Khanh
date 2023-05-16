package codegym.phone_management.service;

import codegym.phone_management.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();
    Phone findById(Long id);
    Phone save (Phone phone);
    void remove(Long id);
}
