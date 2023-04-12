package codegym.bookborrow.controller;

import codegym.bookborrow.model.Book;
import codegym.bookborrow.model.BookBorrow;
import codegym.bookborrow.service.BookBorrowService;
import codegym.bookborrow.service.BookService;
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

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookBorrowService bookBorrowService;

    @GetMapping("")
    public String list(@RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort,
                       Model model) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("name");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        Page<Book> books = bookService.findAll(pageable);

        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }
    @PostMapping("/create")
    public String create(Book book) {
        bookService.save(book);
        return "redirect:/book";
    }


    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBook(book);
        model.addAttribute("bookBorrow", bookBorrow);
        return "book/info";
    }

    @GetMapping("/borrow")
    public String borrow(BookBorrow bookBorrow) {
        Book book = bookBorrow.getBook();
        if (book.getAmount() == 0) {
            return "book/book-borrow-out";
        }
        Integer code;
        do {
            code = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
        } while (bookBorrowService.isExistBorrowCode(code));
        bookBorrow.setBorrowCode(code);
        bookBorrowService.save(bookBorrow);
        book.setAmount(book.getAmount() - 1);
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/return-book")
    public String showReturnBookForm() {
        return "book/return-book";
    }

    @GetMapping("/check-borrow-code")
    public String returnBookConfirm(@RequestParam("borrow_code") String borrowCodeStr, Model model) {
        Integer borrowCode = 0;
        try {
            borrowCode = Integer.parseInt(borrowCodeStr);
            if (bookBorrowService.isExistBorrowCode(borrowCode)) {
                BookBorrow bookBorrow = bookBorrowService.findBookBorrowByBorrowCode(borrowCode);
                model.addAttribute("bookBorrow", bookBorrow);
                return "book/return-book-confirm";
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Wrong code");
            return "book/return-book";
        }
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("id") BookBorrow bookBorrow, Model model) {
            Book book = bookBorrow.getBook();
            book.setAmount(book.getAmount() + 1);
            bookService.save(book);
            bookBorrowService.delete(bookBorrow);
            return "redirect:/book";
    }
}
