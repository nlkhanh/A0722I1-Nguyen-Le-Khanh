package codegym.shopping_cart.controller;

import codegym.shopping_cart.model.Cart;
import codegym.shopping_cart.model.Product;
import codegym.shopping_cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    private String addToCart(@PathVariable("id") Product product,
                             @ModelAttribute("cart") Cart cart,
                             @RequestParam("action") String action) {
        if (product == null) {
            return "error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        } else if (action.equals("info")) {
            cart.addProduct(product);
            return "redirect:/info/" + product.getId();
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    private String deleteFromCart(@PathVariable("id") Product product,
                                  @ModelAttribute("cart") Cart cart) {
        cart.deleteProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    private String removeFromCart(@PathVariable("id") Product product,
                                  @ModelAttribute("cart") Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        if (products.get(product) == 1) {
            cart.deleteProduct(product);
        } else {
            cart.removeProduct(product);
        }
        return "redirect:/shopping-cart";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Product product,
                       Model model) {
        model.addAttribute("product", product);
        return "info";
    }
}
