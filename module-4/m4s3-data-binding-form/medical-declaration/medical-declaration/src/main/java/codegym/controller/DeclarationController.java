package codegym.controller;

import codegym.com.Common;
import codegym.com.Validate;
import codegym.model.DeclarationForm;
import codegym.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {
    @Autowired
    private DeclarationService declarationService;

    @GetMapping("/declaration")
    public String getDeclaration(Model model) {
        model.addAttribute("declarationForm", declarationService.getForm());
        model.addAttribute("years", Common.getYears());
        model.addAttribute("months", Common.getMonths());
        model.addAttribute("days", Common.getDays());
        model.addAttribute("genders", Common.getGenders());
        model.addAttribute("nationalities", Common.getNationalities());
        model.addAttribute("moveInfos", Common.getMoveInfo());
        model.addAttribute("provinces", Common.getProvinces());
        model.addAttribute("districts", Common.getDistricts());
        model.addAttribute("wards", Common.getWards());
        return "declaration";
    }

    @PostMapping("/declaration")
    public String postDeclaration(@ModelAttribute("declarationForm") DeclarationForm declarationForm, RedirectAttributes redirectAttributes) {
        if (Validate.validateForm(declarationForm)) {
            declarationService.save(declarationForm);
            redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm không thành công!");
            redirectAttributes.addFlashAttribute("declarationForm", declarationForm);
        }
        return "redirect: /declaration";
    }
}
