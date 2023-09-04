package com.ditt.innocheck.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.*;

@Entity
@Table(name = "device_loans")
@Data
public class DeviceLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime loanStartDateTime;
    private int loanDurationHours;
    
    // Relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    
    // Getters and setters
}
