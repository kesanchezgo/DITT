/* package com.bezkoder.spring.security.postgresql.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "equipments")
public class Equipment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 200)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EDevice type;

  @ManyToOne
  private User borrower;

  @NotNull
  private LocalDateTime borrowStartDate;

  @NotNull
  private LocalDateTime borrowEndDate;

  public Equipment() {
  }

  public Equipment(String name, String description, EDevice type, User borrower, LocalDateTime borrowStartDate, LocalDateTime borrowEndDate) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.borrower = borrower;
    this.borrowStartDate = borrowStartDate;
    this.borrowEndDate = borrowEndDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EDevice getType() {
    return type;
  }

  public void setType(EDevice type) {
    this.type = type;
  }

  public User getBorrower() {
    return borrower;
  }

  public void setBorrower(User borrower) {
    this.borrower = borrower;
  }

  public LocalDateTime getBorrowStartDate() {
    return borrowStartDate;
  }

  public void setBorrowStartDate(LocalDateTime borrowStartDate) {
    this.borrowStartDate = borrowStartDate;
  }

  public LocalDateTime getBorrowEndDate() {
    return borrowEndDate;
  }

  public void setBorrowEndDate(LocalDateTime borrowEndDate) {
    this.borrowEndDate = borrowEndDate;
  }
}
 */