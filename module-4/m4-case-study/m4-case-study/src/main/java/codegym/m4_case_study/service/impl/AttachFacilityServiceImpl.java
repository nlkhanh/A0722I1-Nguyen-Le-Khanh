package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.AttachFacility;
import codegym.m4_case_study.repository.AttachFacilityRepository;
import codegym.m4_case_study.service.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttachFacilityServiceImpl implements AttachFacilityService {
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;

    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return attachFacilityRepository.findAll(pageable);
    }

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(Long id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public AttachFacility save(AttachFacility attachFacility) {
        return attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void deleteById(Long id) {
        attachFacilityRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        attachFacilityRepository.deleteAllByIdIn(deleteIds);
    }
}
