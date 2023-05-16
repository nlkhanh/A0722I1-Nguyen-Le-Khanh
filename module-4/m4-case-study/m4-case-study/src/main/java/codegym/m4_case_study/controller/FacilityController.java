package codegym.m4_case_study.controller;

import codegym.m4_case_study.model.Facility;
import codegym.m4_case_study.model.FacilityType;
import codegym.m4_case_study.model.RentType;
import codegym.m4_case_study.service.FacilityService;
import codegym.m4_case_study.service.FacilityTypeService;
import codegym.m4_case_study.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/furama-resort/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private FacilityTypeService facilityTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping
    public String list(Model model,
                       @RequestParam("search") Optional<String> search,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        model.addAttribute("facilities", facilityService.findAllSearch(searchValue, pageable));
        model.addAttribute("search", searchValue);
        return "furama-resort/facility/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Facility facility = new Facility();
        facility.setFacilityType(new FacilityType());
        facility.setRentType(new RentType());
        model.addAttribute("facility", facility);
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("title", "Tạo mới dịch vụ");
        model.addAttribute("buttonSubmitName", "Thêm");
        return "furama-resort/facility/createAndUpdate";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Facility facility = facilityService.findById(id);
        model.addAttribute("facility", facility);
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("title", "Cập nhật dịch vụ");
        model.addAttribute("buttonSubmitName", "Cập Nhật");
        return "furama-resort/facility/createAndUpdate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facility") Facility facility, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "New facility has created.");
        if (facility.getId() != null) {
            attributes.addFlashAttribute("message", "A facility has updated.");
        }
        facilityService.save(facility);
        return "redirect:/furama-resort/facility";
    }
}
