package furama_resort.repository;

import furama_resort.model.GeneralType;

import java.util.List;

public interface IGeneralRepository {
    List<GeneralType> getAll(String typeName);
}
