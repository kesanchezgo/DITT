package com.ditt.innocheck.repositories;

import com.ditt.innocheck.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Puedes agregar métodos personalizados para consultas aquí si es necesario
}
