package com.bezkoder.spring.security.postgresql.models;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_confirmations")
public class LoanConfirmation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "loan_request_id")
  private LoanRequest loanRequest;

  private Boolean confirmed;

  public LoanConfirmation() {
  }

  public LoanConfirmation(LoanRequest loanRequest, Boolean confirmed) {
    this.loanRequest = loanRequest;
    this.confirmed = confirmed;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LoanRequest getLoanRequest() {
    return this.loanRequest;
  }

  public void setLoanRequest(LoanRequest loanRequest) {
    this.loanRequest = loanRequest;
  }

  public Boolean isConfirmed() {
    return this.confirmed;
  }

  public Boolean getConfirmed() {
    return this.confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }
  
}
