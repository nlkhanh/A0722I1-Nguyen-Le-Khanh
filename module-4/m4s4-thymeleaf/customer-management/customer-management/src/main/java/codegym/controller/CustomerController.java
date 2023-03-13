package codegym.controller;

import codegym.model.Customer;
import codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @GetMapping("/{id}/edit")
    public String getEdit(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String getRemove(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "delete";
    }

    @GetMapping("/{id}/view")
    public String getView (@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "view";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 1000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Create succeed");
        return "redirect: /customer";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("success", "Update succeed");
        return "redirect: /customer";
    }

    @PostMapping("/remove")
    public String postRemove(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Remove succeed");
        return "redirect: /customer";
    }
}
