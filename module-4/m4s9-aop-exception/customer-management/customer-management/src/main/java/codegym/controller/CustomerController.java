package codegym.controller;

import codegym.exception.DuplicateEmailException;
import codegym.model.Customer;
import codegym.model.Province;
import codegym.service.CustomerService;
import codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    private List<Province> allProvinces() {
        return provinceService.findAll();
    }

    @GetMapping("")
    public String list(Model model,
                       Optional<String> s,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(2);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        Page<Customer> customers = s.isPresent() ? customerService.findAllByNameContainingOrEmailContainingOrAddressContaining(s.get(), s.get(), s.get(), pageable) : customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("keyword", s.orElse(null));
        return "customer/list";
    }

    @GetMapping("/{id}")
    public String showInformation(@PathVariable Long id, Model model) {
        try {
            Customer customer = customerService.findById(id);
            model.addAttribute("customer", customer);
            return "customer/info";
        } catch (Exception e) {
            return "redirect:/customers";
        }
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer) throws DuplicateEmailException {
            customerService.save(customer);
            return "redirect:/customers";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public String showInputsAcceptable() {
        return "inputs-not-acceptable";
    }
}
