package codegym.m4_case_study.service.impl;

import codegym.m4_case_study.model.Position;
import codegym.m4_case_study.repository.PositionRepository;
import codegym.m4_case_study.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Page<Position> findAll(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public Position save(Position facilityType) {
        return positionRepository.save(facilityType);
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> deleteIds) {
        positionRepository.deleteAllByIdIn(deleteIds);
    }
}
