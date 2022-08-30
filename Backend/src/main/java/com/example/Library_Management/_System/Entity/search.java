package com.example.Library_Management._System.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Books")
public class search {
    private String title;
}
// generate get and set methods for all the fields
// generate constructor with all the fields
// generate getters and setters for all the fields

