package com.example.Library_Management._System.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Library_Management._System.Models.ERole;
import com.example.Library_Management._System.Entity.Role;
public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
