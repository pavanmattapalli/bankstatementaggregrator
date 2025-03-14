// src/main/java/com/example/aggregator/repositories/BankStatementRepository.java
package com.example.aggregator.repositories;

import com.example.aggregator.models.BankStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {
}
