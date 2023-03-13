package codegym.controller;

import codegym.model.Product;
import codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/search")
    public String index(@RequestParam("nameSearch") String name, Model model) {
        List<Product> products = productService.findByName(name);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("/{id}/edit")
    public String create(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Save succeed");
        return "redirect: /product";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Update succeed");
        return "redirect: /product";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Remove succeed");
        return "redirect: /product";
    }
}
