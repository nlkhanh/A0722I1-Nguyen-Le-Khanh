package codegym.controller;

import codegym.model.Customer;
import codegym.model.Province;
import codegym.service.CustomerService;
import codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/create-customer";
    }

    @GetMapping("/customers")
    public String list(@RequestParam("search") Optional<String> search, Model model, Pageable pageable) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributese) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/edit";
        } else {
            redirectAttributese.addFlashAttribute("message", "Error");
            return "redirect:/customers";
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("customer", customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/edit-customer/" + customer.getId();
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/delete";
        } else {
            redirectAttributes.addFlashAttribute("message", "Error");
            return "redirect:/customers";
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }

    @GetMapping("/view-province/{id}")
    public String viewProvince(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
        Province province = provinceService.findById(id);
        if(province == null){
            redirectAttributes.addFlashAttribute("message", "Error");
            return "redirect:/customers";
        }
        List<Customer> customers = customerService.findAllByProvince(province);
        model.addAttribute("province", province);
        model.addAttribute("customers", customers);
        return "province/view";
    }
}
