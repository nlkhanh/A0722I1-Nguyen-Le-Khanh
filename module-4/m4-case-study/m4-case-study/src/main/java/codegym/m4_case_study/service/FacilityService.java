package codegym.m4_case_study.service;

import codegym.m4_case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacilityService extends GeneralService<Facility> {
    Page<Facility> findAllSearch(String search, Pageable pageable);
}
