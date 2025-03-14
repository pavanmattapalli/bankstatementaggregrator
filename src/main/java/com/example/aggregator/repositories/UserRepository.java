// src/main/java/com/example/aggregator/repositories/UserRepository.java
package com.example.aggregator.repositories;

import com.example.aggregator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
