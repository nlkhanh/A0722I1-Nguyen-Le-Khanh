package codegym.controller;

import codegym.model.Customer;
import codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.insertWithStoredProcedure(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/create-customer";
    }

    @GetMapping("/customers")
    public String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributese) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "edit";
        } else {
            redirectAttributese.addFlashAttribute( "message", "Error");
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
            return "delete";
        } else {
            redirectAttributes.addFlashAttribute("message", "Error");
            return "redirect:/customers";
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }}