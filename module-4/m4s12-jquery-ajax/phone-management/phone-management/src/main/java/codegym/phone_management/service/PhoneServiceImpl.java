package codegym.phone_management.service;

import codegym.phone_management.model.Phone;
import codegym.phone_management.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.deleteById(id);
    }
}
