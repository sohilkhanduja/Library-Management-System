package com.example.Library_Management._System.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Library_Management._System.Entity.Books;
import com.example.Library_Management._System.Repository.BookRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class searchController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/search")

    public List<Books> searchBook(@RequestBody com.example.Library_Management._System.Entity.search search) {
        List<Books> search1 = new ArrayList<Books>();
        List<Books> books = bookRepository.findAll();
        for (Books book : books) {
            String d = book.getTitle();
            int counter = 0;
            String title = search.getTitle();
            for (int i = 0; i < d.length(); i++) {
                if (d.charAt(i) == title.charAt(counter)) {
                    counter+=1;
                }
                else {
                    counter = 0;
                }
                if(counter == title.length() - 1)
                {
                    search1.add(book);
                    break;
                }
            }
        }
        return search1;
    }
    
}
