package com.example.Library_Management._System.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Library_Management._System.Entity.Books;
import com.example.Library_Management._System.Entity.search;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class searchController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/search")
    public List<Books> searchBook(@RequestBody search search) {
        Query query = new Query();
        query.addCriteria(new org.springframework.data.mongodb.core.query.Criteria("title").regex(search.getTitle()));
        List <Books> books = mongoTemplate.find(query, Books.class);
        if (books.isEmpty()) {
            return null;
        }
        return books;
    }
    
}
