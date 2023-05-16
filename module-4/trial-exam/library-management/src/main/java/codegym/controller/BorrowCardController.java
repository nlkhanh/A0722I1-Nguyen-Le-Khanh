package codegym.controller;

import codegym.entity.Book;
import codegym.entity.BorrowCard;
import codegym.entity.Student;
import codegym.service.BookService;
import codegym.service.BorrowCardService;
import codegym.service.StudentService;
import codegym.validation.BorrowCardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/borrow-cards")
public class BorrowCardController {
    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BorrowCardService borrowCardService;

    @Autowired
    private BorrowCardValidation borrowCardValidation;

    @GetMapping("/create/{bookId}")
    public String showBorrowForm(@PathVariable("bookId") Long bookId, Model model, RedirectAttributes attributes) {
        Book book = bookService.findById(bookId);
        if (book.getQuantity() == 0) {
            attributes.addFlashAttribute("mess", "Cuốn sách này tạm thời đã cho mượn hết. Vui lòng chọn sách khác.");
            return "redirect:/books";
        }
        BorrowCard borrowCard = new BorrowCard();
        borrowCard.setBook(book);
        borrowCard.setBorrowDate(LocalDate.now());
        borrowCard.setStudent(new Student());
        model.addAttribute("borrowCard", borrowCard);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "borrow-cards/create-and-update";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute("borrowCard") BorrowCard borrowCard, BindingResult result, RedirectAttributes attributes, Model model) {
        borrowCardValidation.validate(borrowCard, result);
        if (result.hasErrors()) {
            model.addAttribute("borrowCard", borrowCard);
            List<Student> students = studentService.findAll();
            model.addAttribute("students", students);
            return "borrow-cards/create-and-update";
        }
        borrowCardService.save(borrowCard);
        Book book = borrowCard.getBook();
        book.degreeQuantity();
        bookService.save(book);
        attributes.addFlashAttribute("message", "Một sách đã được mượn thành công");
        return "redirect:/books";
    }

    @GetMapping
    public String list(Model model, @RequestParam("bookNameSearch") Optional<String> bookNameSearch, @RequestParam("studentNameSearch") Optional<String> studentNameSearch) {
        String bookName = bookNameSearch.orElse("");
        String studentName = studentNameSearch.orElse("");
        List<BorrowCard> borrowCards = borrowCardService.findAll(bookName, studentName);
        model.addAttribute("bookName", bookName);
        model.addAttribute("studentName", studentName);
        model.addAttribute("borrowCards", borrowCards);
        return "borrow-cards/list";
    }
}
