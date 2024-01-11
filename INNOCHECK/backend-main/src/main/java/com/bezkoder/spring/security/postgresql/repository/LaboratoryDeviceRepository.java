package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.LaboratoryDevice;
import com.bezkoder.spring.security.postgresql.models.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryDeviceRepository extends JpaRepository<LaboratoryDevice, Long> {
    
}
