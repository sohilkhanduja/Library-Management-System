package com.example.Library_Management._System.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Books")
public class Books{
    @Id
    private String bookId;
    private String title;
    private String author;
    private String year_written;
    private String edition;
    private String price;
    private String isbn;
    private boolean availability;
}

