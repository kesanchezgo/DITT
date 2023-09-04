package com.ditt.innocheck.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    // Relationships
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    
    // Getters and setters
}
