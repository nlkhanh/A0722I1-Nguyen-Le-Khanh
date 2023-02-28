package furama_resort.service;

import furama_resort.model.GeneralType;

import java.util.List;

public interface IGeneralTypeService {
    List<GeneralType> getAll(String typeName);
}
