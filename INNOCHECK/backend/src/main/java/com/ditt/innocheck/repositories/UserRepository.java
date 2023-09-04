package com.ditt.innocheck.repositories;

import com.ditt.innocheck.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Puedes agregar métodos personalizados para consultas aquí si es necesario

    public User findUserByDni(String dni);
}
