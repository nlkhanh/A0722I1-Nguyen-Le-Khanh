package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.RentType;
import codegym.m4_case_study.repository.RentTypeRepository;
import codegym.m4_case_study.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RentType save(RentType facilityType) {
        return rentTypeRepository.save(facilityType);
    }

    @Override
    public void deleteById(Long id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        rentTypeRepository.deleteAllByIdIn(deleteIds);
    }
}
