package com.example.Library_Management._System.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Library_Management._System.Entity.search;
public interface searchRepository extends MongoRepository<search, String> {
    Optional<search> findByTitle(String title);
}
