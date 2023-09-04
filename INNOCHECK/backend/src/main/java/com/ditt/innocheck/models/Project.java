package com.ditt.innocheck.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String projectName;
    private String recordId;
    private String technology;
    private String challenge;
    
    // Relationships
     @ManyToMany
    @JoinTable(
        name = "project_user",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants = new HashSet<>();
    
    // Getters and setters
}
