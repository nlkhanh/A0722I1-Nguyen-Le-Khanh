package codegym.com;

import codegym.model.DeclarationForm;

public class Validate {
    public static boolean validateForm(DeclarationForm declarationForm) {
        return !(declarationForm.getName().equals("") ||
                declarationForm.getBirthYear().equals("") ||
                declarationForm.getGender() == null ||
                declarationForm.getNationality().equals("") ||
                declarationForm.getId().equals("") ||
                declarationForm.getMovingInfo() == null ||
                declarationForm.getStartDay() == null ||
                declarationForm.getStartMonth() == null ||
                declarationForm.getStartYear() == null ||
                declarationForm.getEndDay() == null ||
                declarationForm.getEndMonth() == null ||
                declarationForm.getEndYear() == null ||
                declarationForm.getRecentMove().equals("") ||
                declarationForm.getProvince() == null ||
                declarationForm.getDistrict() == null ||
                declarationForm.getWard() == null ||
                declarationForm.getStreet().equals("") ||
                declarationForm.getPhone().equals(""));
    }
}
