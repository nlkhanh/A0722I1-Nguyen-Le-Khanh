package codegym.repository;

import codegym.model.DeclarationForm;
import org.springframework.stereotype.Repository;

@Repository
public class DeclarationRepositoryImpl implements DeclarationRepository{
    private static DeclarationForm form = new DeclarationForm();


    @Override
    public void save(DeclarationForm declarationForm) {
         form = declarationForm;
    }

    @Override
    public DeclarationForm getForm() {
        return form;
    }
}
