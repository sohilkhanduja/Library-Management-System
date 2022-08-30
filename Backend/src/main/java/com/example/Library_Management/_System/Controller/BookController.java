package com.example.Library_Management._System.Controller;
import java.util.ArrayList;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Book_BorrowedRepository book_BorrowedRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Books>> getAllBooks(Books book) {
        List<Books> books = bookRepository.findAll();
        return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            return new ResponseEntity<Books>(book, HttpStatus.BAD_REQUEST);
    }
    book.setAvailability(true);
    bookRepository.save(book);
    return new ResponseEntity<Books>(book, HttpStatus.OK);
    }
    // public ResponseEntity<List<Books_Borrowed>>(@RequestBody Books book) {
    //     book.setAvailability(true);
    //     if (bookRepository.existsByIsbn(book.getIsbn())) {
    //         return "ISBN already exists, enter another ISBN " + HttpStatus.CONFLICT;
    //     }
    //     bookRepository.save(book);
    //     return "Book added successfully "+HttpStatus.OK;
    @GetMapping("/all/user")
    public ResponseEntity<List<Books_Borrowed>> getAllBooksBorrowedByUser() {
        List<Books_Borrowed> books = new ArrayList<Books_Borrowed>();
        for (Books_Borrowed book : book_BorrowedRepository.findAll()) {
            if (book.getStatus()) {
                books.add(book);
            }
         }
        return new ResponseEntity<List<Books_Borrowed>>(books, HttpStatus.OK);
    }
}
    // @DeleteMapping("/delete/{bookId}")
    // public String deleteBook(@PathVariable("bookId")String bookId) {
    //     if (!bookRepository.existsById(bookId)) {
    //         return "Book not found " + HttpStatus.NOT_FOUND;
    //     }
    //     bookRepository.deleteById(bookId);
    //     return "Book deleted successfully as it was borrowed "+HttpStatus.OK;
    // }

