package com.bezkoder.spring.security.postgresql.models;

import java.util.Set;
import java.time.LocalDateTime;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_requests")
public class LoanRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToMany
  @JoinTable(name = "loan_request_devices", joinColumns = @JoinColumn(name = "loan_request_id"), inverseJoinColumns = @JoinColumn(name = "laboratory_device_id"))
  private Set<LaboratoryDevice> devices = new HashSet<>();

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String status;
  
  private int quantity;  

  public LoanRequest() {
  }

  public LoanRequest(User user, Set<LaboratoryDevice> devices, LocalDateTime startDate, LocalDateTime endDate, String status, int quantity) {
    this.user = user;
    this.devices = devices;
    this.startDate = startDate;
    this.endDate = endDate;
    this.status = status;
    this.quantity = quantity;
  }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<LaboratoryDevice> getDevices() {
        return this.devices;
    }

    public void setDevices(Set<LaboratoryDevice> devices) {
        this.devices = devices;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
}
