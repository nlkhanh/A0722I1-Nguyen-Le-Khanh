package codegym.service;

import codegym.model.DeclarationForm;
import codegym.repository.DeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationServiceImpl implements DeclarationService{
    @Autowired
    private DeclarationRepository declarationRepository;

    @Override
    public void save(DeclarationForm declarationForm) {
        declarationRepository.save(declarationForm);
    }

    @Override
    public DeclarationForm getForm() {
        return declarationRepository.getForm();
    }
}
