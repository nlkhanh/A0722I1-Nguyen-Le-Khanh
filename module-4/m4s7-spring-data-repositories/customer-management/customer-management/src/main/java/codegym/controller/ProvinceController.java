package codegym.controller;

import codegym.model.Province;
import codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public String listProvinces(Model model) {
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "province/list";
    }

    @GetMapping("/create-province")
    public String showCreateForm(Model model) {
        model.addAttribute("province", new Province());
        return "province/create";
    }

    @PostMapping("/create-province")
    public String saveProvince(@ModelAttribute("province") Province province, Model model) {
        provinceService.save(province);
        model.addAttribute("province", new Province());
        model.addAttribute("message", "New province created successfully");
        return "province/create";
    }

    @GetMapping("/edit-province/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Province province = provinceService.findById(id);
        if (province != null) {
            model.addAttribute("province", province);
            return "province/edit";
        } else {
            redirectAttributes.addFlashAttribute("message", "Error404.");
            return "redirect:/provinces";
        }
    }

    @PostMapping("/edit-province")
    public String updateProvince(@ModelAttribute("province") Province province, Model model) {
        provinceService.save(province);
        model.addAttribute("province", province);
        model.addAttribute("message", "Province updated successfully");
        return "province/edit";
    }

    @GetMapping("/delete-province/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Province province = provinceService.findById(id);
        if (province != null) {
            model.addAttribute("province", province);
            return "province/delete";
        } else {
            redirectAttributes.addFlashAttribute("message", "Error404.");
            return "redirect:/provinces";
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getProvinceId());
        return "redirect:provinces";
    }
}
