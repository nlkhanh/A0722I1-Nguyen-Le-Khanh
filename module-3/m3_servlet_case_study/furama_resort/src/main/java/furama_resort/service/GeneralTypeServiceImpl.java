package furama_resort.service;

import furama_resort.model.GeneralType;
import furama_resort.repository.GeneralTypeRepositoryImpl;
import furama_resort.repository.IGeneralRepository;

import java.util.List;

public class GeneralTypeServiceImpl implements IGeneralTypeService {
    private static final IGeneralRepository GENERAL_TYPE_REPOSITORY = new GeneralTypeRepositoryImpl();


    @Override
    public List<GeneralType> getAll(String typeName) {
        return GENERAL_TYPE_REPOSITORY.getAll(typeName);
    }
}
