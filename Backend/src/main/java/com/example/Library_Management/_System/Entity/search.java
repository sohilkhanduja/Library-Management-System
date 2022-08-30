<<<<<<< HEAD:Backend/src/main/java/com/example/Library_Management/_System/Entity/search.java
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

=======
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
>>>>>>> 2d1adaf06fb40f2e05ea04e7d9b8d2c50cbdb95e:Backend/src/main/java/com/example/Library_Management/_System/Entity/search.java
