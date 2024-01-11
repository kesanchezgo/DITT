package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.LoanConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanConfirmationRepository extends JpaRepository<LoanConfirmation, Long> {
}
