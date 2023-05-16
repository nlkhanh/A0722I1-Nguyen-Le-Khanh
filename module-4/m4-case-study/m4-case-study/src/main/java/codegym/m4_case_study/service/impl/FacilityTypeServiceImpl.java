package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.FacilityType;
import codegym.m4_case_study.repository.FacilityTypeRepository;
import codegym.m4_case_study.service.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacilityTypeServiceImpl implements FacilityTypeService {
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    @Override
    public Page<FacilityType> findAll(Pageable pageable) {
        return facilityTypeRepository.findAll(pageable);
    }

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(Long id) {
        return facilityTypeRepository.findById(id).orElse(null);
    }

    @Override
    public FacilityType save(FacilityType facilityType) {
        return facilityTypeRepository.save(facilityType);
    }

    @Override
    public void deleteById(Long id) {
        facilityTypeRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        facilityTypeRepository.deleteAllByIdIn(deleteIds);
    }
}
