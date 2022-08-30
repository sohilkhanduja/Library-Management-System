package com.example.Library_Management._System.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Library_Management._System.Entity.Books;
import com.example.Library_Management._System.Entity.Books_Borrowed;
import com.example.Library_Management._System.Repository.BookRepository;
import com.example.Library_Management._System.Repository.Book_BorrowedRepository;
import com.example.payload.response.MessageResponse;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/borrow")
public class BorrowedController {
    @Autowired
    private Book_BorrowedRepository book_BorrowedRepository;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Books_Borrowed>> getAllBorrowed() {
        List<Books_Borrowed> borrowed =book_BorrowedRepository.findAll();
        return new ResponseEntity<List<Books_Borrowed>>(borrowed, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addBorrowed(@RequestBody Books_Borrowed borrowed) {
        borrowed.setStatus(true);
        //bad request if book is not available
        if (book_BorrowedRepository.findByUsername(borrowed.getUsername()).size() == 1) {
           return ResponseEntity.badRequest().body(new MessageResponse("User already has a book borrowed"));
        }
        if (!bookRepository.existsByIsbn(borrowed.getIsbn()) || !bookRepository.existsBytitle(borrowed.getTitle()) || !bookRepository.existsByauthor(borrowed.getAuthor())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Book not found"));
        }
        for (Books books : bookRepository.findAll()) {
            if (books.getIsbn().equals(borrowed.getIsbn()) && books.isAvailability() == true) {
                books.setAvailability(false);
                bookRepository.save(books);
                book_BorrowedRepository.save(borrowed);
            return ResponseEntity.ok(new MessageResponse("Book borrowed successfully"));
            }
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Book not available"));
    }
    @PostMapping("/return")
    public String returnBorrowed(@RequestBody Books_Borrowed borrowed) {
        if (!book_BorrowedRepository.existsByUsername(borrowed.getUsername())) {
            return "User has not borrowed any book " + ResponseEntity.badRequest();
        }
        if (book_BorrowedRepository.findByUsername(borrowed.getUsername()).size() == 0) {
            return "User has not borrowed any book " + ResponseEntity.badRequest();
        }
        else
        {
            for (Books_Borrowed b : book_BorrowedRepository.findByUsername(borrowed.getUsername())) {
                b.setStatus(false);
                book_BorrowedRepository.save(b);
            }
            for (Books books : bookRepository.findAll()) {
                if (books.getIsbn().equals(borrowed.getIsbn())) {
                    books.setAvailability(true);
                    bookRepository.save(books);
                }
            }
            return "Book returned successfully "+HttpStatus.OK;
        }
    }
}
