package com.ditt.innocheck.repositories;

import com.ditt.innocheck.models.DeviceLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceLoanRepository extends JpaRepository<DeviceLoan, Long> {
    // Puedes agregar métodos personalizados para consultas aquí si es necesario
}
