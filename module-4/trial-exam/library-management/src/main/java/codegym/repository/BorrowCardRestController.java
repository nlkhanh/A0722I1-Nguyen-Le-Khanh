package codegym.repository;

import codegym.entity.Book;
import codegym.entity.BorrowCard;
import codegym.service.BookService;
import codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow-cards")
public class BorrowCardRestController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowCardService borrowCardService;

    @GetMapping
    public ResponseEntity<?> returnBook(@RequestParam("id") String id) {
        BorrowCard borrowCard= borrowCardService.findById(id);
        borrowCard.setBorrowing(false);
        Book book = borrowCard.getBook();
        book.increaseQuantity();
        bookService.save(book);
        borrowCardService.save(borrowCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
