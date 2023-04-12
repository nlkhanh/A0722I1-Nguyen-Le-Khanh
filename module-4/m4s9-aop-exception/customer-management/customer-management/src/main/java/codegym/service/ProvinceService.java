package codegym.service;

import codegym.model.Province;

import java.util.List;

public interface ProvinceService extends GeneralService<Province>{
    List<Province> findAll();
}
