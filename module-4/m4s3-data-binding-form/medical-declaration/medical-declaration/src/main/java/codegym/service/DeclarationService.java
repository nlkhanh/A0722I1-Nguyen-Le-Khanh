package codegym.service;

import codegym.model.DeclarationForm;

public interface DeclarationService {
   void save(DeclarationForm declarationForm);
   DeclarationForm getForm();
}
