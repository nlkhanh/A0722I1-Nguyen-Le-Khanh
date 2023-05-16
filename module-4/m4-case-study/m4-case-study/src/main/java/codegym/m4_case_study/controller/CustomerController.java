package codegym.m4_case_study.controller;

import codegym.m4_case_study.model.*;
import codegym.m4_case_study.service.CustomerService;
import codegym.m4_case_study.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/furama-resort/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

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
        Page<Customer> customers = customerService.findAllSearch(searchValue, pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("search", searchValue);
        return "furama-resort/customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Customer customer = new Customer();
        customer.setCustomerType(new CustomerType());
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("title", "Tạo mới khách hàng");
        model.addAttribute("buttonSubmitName", "Thêm");
        return "furama-resort/customer/createAndUpdate";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("title", "Cập nhật khách hàng");
        model.addAttribute("buttonSubmitName", "Cập Nhật");
        return "furama-resort/customer/createAndUpdate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "New customer has created.");
        if (customer.getId() != null) {
            attributes.addFlashAttribute("message", "A customer has updated.");
        }
        customerService.save(customer);
        return "redirect:/furama-resort/customer";
    }
}
