package com.example.Library_Management._System.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Library_Management._System.Entity.User;
import com.example.Library_Management._System.Repository.UserRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @Autowired
  private UserRepository user;
  @PreAuthorize("hasRole('MODERATOR')")
  @GetMapping("/mod")
  public ResponseEntity<List<User>> getAllusers() {
    List<User> users = user.findAll();
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }
  // @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/admin")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = user.findAll();
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }
}