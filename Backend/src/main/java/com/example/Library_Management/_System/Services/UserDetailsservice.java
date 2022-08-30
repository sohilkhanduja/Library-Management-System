package com.example.Library_Management._System.Services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public interface UserDetailsservice {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
