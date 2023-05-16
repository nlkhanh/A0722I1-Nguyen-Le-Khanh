package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.Facility;
import codegym.m4_case_study.repository.FacilityRepository;
import codegym.m4_case_study.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public void deleteById(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        facilityRepository.deleteAllByIdIn(deleteIds);
    }

    @Override
    public Page<Facility> findAllSearch(String search, Pageable pageable) {
        return facilityRepository.findAllSearch(search, pageable);
    }
}
