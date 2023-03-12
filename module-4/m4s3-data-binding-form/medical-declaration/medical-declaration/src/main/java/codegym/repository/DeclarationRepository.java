package codegym.repository;

import codegym.model.DeclarationForm;

public interface DeclarationRepository {
    void save(DeclarationForm declarationForm);
    DeclarationForm getForm();
}
