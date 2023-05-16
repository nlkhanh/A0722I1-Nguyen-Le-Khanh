package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.EducationDegree;
import codegym.m4_case_study.repository.EducationDegreeRepository;
import codegym.m4_case_study.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Page<EducationDegree> findAll(Pageable pageable) {
        return educationDegreeRepository.findAll(pageable);
    }

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public EducationDegree save(EducationDegree educationDegree) {
        return educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void deleteById(Long id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        educationDegreeRepository.deleteAllByIdIn(deleteIds);
    }
}
