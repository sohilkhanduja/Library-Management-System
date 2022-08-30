package com.example.Library_Management._System.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Library_Management._System.Entity.Books;
public interface BookRepository extends MongoRepository<Books, String> {
    Optional<Books> findByBookId(String bookId);
    boolean existsByIsbn(String isbn);
    boolean existsBytitle(String title);
    boolean existsByauthor(String author);
    boolean existsById(String bookId);
    boolean existsByAvailability(boolean availability);    
}