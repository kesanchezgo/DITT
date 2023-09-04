package com.ditt.innocheck.models;

//import javax.persistence.*;
import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "devices")
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String deviceName;
    private int availableQuantity;
    
    // Relationships
    @OneToMany(mappedBy = "device")
    private List<DeviceLoan> deviceLoans = new ArrayList<>();
    
    // Getters and setters
}
