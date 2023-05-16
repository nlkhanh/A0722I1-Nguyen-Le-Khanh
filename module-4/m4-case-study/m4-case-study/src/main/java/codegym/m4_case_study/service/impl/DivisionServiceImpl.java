package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.Division;
import codegym.m4_case_study.repository.DivisionRepository;
import codegym.m4_case_study.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Page<Division> findAll(Pageable pageable) {
        return divisionRepository.findAll(pageable);
    }

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public Division save(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public void deleteById(Long id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        divisionRepository.deleteAllByIdIn(deleteIds);
    }
}
