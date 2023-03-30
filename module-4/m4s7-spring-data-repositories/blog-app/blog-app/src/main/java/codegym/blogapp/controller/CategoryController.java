package codegym.blogapp.controller;

import codegym.blogapp.model.Category;
import codegym.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String list(Model model, Pageable pageable) {
        Page<Category> categoryList = categoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public String create(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "New category was created.");
        return "redirect:/category/create";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }
    @PostMapping("/update")
    public String edit(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "The category was edited.");
        return "redirect:/category/edit/" + category.getId();
    }
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/delete";
    }
    @PostMapping("/remove")
    public String remove(Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message", "A category was deleted.");
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }
}
