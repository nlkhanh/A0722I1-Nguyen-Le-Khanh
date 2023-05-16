package codegym.library.controller;

import codegym.library.custom_validate.BorrowCardValidate;
import codegym.library.entity.Book;
import codegym.library.entity.BorrowCard;
import codegym.library.entity.Student;
import codegym.library.service.BookService;
import codegym.library.service.BorrowCardService;
import codegym.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BorrowCardService borrowCardService;

    @Autowired
    private BorrowCardValidate borrowCardValidate;

    @GetMapping
    public String list(Model model,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int curPage = page.orElse(0);
        int pSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pSize, Sort.by(sortField));
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrowForm(@PathVariable("id") Long id, Model model, RedirectAttributes attribute) {
        Book book = bookService.findById(id);
        if (book.getQuantity() == 0) {
            attribute.addFlashAttribute("mess", "There is no book for you.");
            return "redirect:/books";
        }
        BorrowCard borrowCard = new BorrowCard();
        borrowCard.setBook(book);
        borrowCard.setStudent(new Student());
        borrowCard.setBorrowDate(LocalDate.now());
        model.addAttribute("borrowCard", borrowCard);
        model.addAttribute("students", studentService.findAll());
        return "books/borrow";
    }

    @PostMapping("/borrow")
    public String borrow(@Validated @ModelAttribute("borrowCard") BorrowCard borrowCard, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
        borrowCardValidate.validate(borrowCard, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("borrowCard", borrowCard);
            model.addAttribute("students", studentService.findAll());
            return "books/borrow";
        }
        borrowCardService.save(borrowCard);
        borrowCard.getBook().degreeQuantity();
        bookService.save(borrowCard.getBook());
        attributes.addFlashAttribute("message", "A book is borrowed.");
        return "redirect:/books";
    }

    @GetMapping("/borrows")
    public String showBorrowBooks(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size,
                                  @RequestParam("sort") Optional<String> sort,
                                  @RequestParam("search-book-name") Optional<String> searchBookName,
                                  @RequestParam("search-student-name") Optional<String> searchStudentName) {
        int curPage = page.orElse(0);
        int pSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pSize, Sort.by(sortField));
        Page<BorrowCard> borrowCards;
        if (searchBookName.isPresent() || searchStudentName.isPresent()) {
            String bookName = searchBookName.orElse("");
            String studentName = searchStudentName.orElse("");
            borrowCards = borrowCardService.findAllBorrowSearch(pageable, bookName, studentName);
            model.addAttribute("searchBookName", bookName);
            model.addAttribute("searchStudentName", studentName);
        } else {
            borrowCards = borrowCardService.findAllBorrow(pageable);
        }
        model.addAttribute("borrowCards", borrowCards);
        return "books/borrows";
    }
}
