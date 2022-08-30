package com.example.Library_Management._System.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Books_Borrowed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books_Borrowed {
    @Id
    private String borrowid;
    private String username;
    private String isbn;
    private String title;
    private String author;
    private Boolean status;
}
