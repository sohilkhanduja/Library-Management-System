package com.example.Library_Management._System.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
	@GetMapping("/")
	public String index() {
		return "Welcome to Library Management System project backend";
	}
}
