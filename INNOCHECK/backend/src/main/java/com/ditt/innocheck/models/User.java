package com.ditt.innocheck.models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String dni;
    
    @Column(nullable = false)
    private String password;
    
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String institution;
    
    // Relationships
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    private List<EntryExitRecord> entryExitRecords = new ArrayList<>();
    
    @OneToMany(mappedBy = "user")
    private List<DeviceLoan> deviceLoans = new ArrayList<>();

    @ManyToMany(mappedBy = "participants")
    private Set<Project> projects = new HashSet<>();
    
    // Getters and setters
}
