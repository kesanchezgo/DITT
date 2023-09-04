package com.ditt.innocheck.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.*;

@Entity
@Table(name = "entry_exit_records")
@Data
public class EntryExitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime entryDateTime;
    private LocalDateTime exitDateTime;
    
    // Relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    // Getters and setters
}
