package com.ditt.innocheck.repositories;

import com.ditt.innocheck.models.EntryExitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryExitRecordRepository extends JpaRepository<EntryExitRecord, Long> {
    // Puedes agregar métodos personalizados para consultas aquí si es necesario
}
