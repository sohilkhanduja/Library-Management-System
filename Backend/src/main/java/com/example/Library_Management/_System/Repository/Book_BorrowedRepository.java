package com.example.Library_Management._System.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.Library_Management._System.Entity.Books_Borrowed;
public interface Book_BorrowedRepository extends MongoRepository<Books_Borrowed, String> {
    Optional<Books_Borrowed> findByBorrowid(String borrowid);
    Boolean existsByUsername(String username);
    @Query ("{username: ?0, status: true}")
    List<Books_Borrowed> findByUsername(String username);
     
}
