package codegym.blogapp.controller;

import codegym.blogapp.model.Blog;

import codegym.blogapp.model.Category;
import codegym.blogapp.service.BlogService;
import codegym.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String list(Model model,
                       @RequestParam("searchTitle") Optional<String> searchTitle,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(2);
        String sortField = sort.orElse("publicDate");
        Sort sortBy = Sort.by(sortField).ascending().and(Sort.by("modifiedDate").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, sortBy);
        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList;
        if (searchTitle.isPresent()) {
            blogList = blogService.findByTitleContainingOrderByPublicDate(searchTitle.get(), pageable);
        } else {
            blogList = blogService.findAll(pageable);
        }
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setPublicDate(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog has created.");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setModifiedDate(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "A blog has updated.");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/delete";
    }

    @PostMapping("/remove")
    public String remove(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Certain blog has removed.");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }
}
