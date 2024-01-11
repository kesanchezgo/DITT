package com.bezkoder.spring.security.postgresql.controllers;

import java.util.HashSet;
import java.util.Set;

import com.bezkoder.spring.security.postgresql.models.LoanConfirmation;
import com.bezkoder.spring.security.postgresql.repository.LoanConfirmationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.security.postgresql.models.LoanRequest;
import com.bezkoder.spring.security.postgresql.models.LaboratoryDevice;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.payload.response.MessageResponse;
import com.bezkoder.spring.security.postgresql.repository.LoanRequestRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.repository.LaboratoryDeviceRepository;

@CrossOrigin(origins = "http://localhost:8100/", maxAge = 3600)
@RestController
@RequestMapping("/api/loan")
public class LoanRequestController {

    @Autowired
    LoanRequestRepository loanRequestRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LaboratoryDeviceRepository laboratoryDeviceRepository;

    @Autowired
    LoanConfirmationRepository loanConfirmationRepository;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/request")
    public ResponseEntity<?> loanRequest(@Valid @RequestBody LoanRequest loanRequestData) {
        // Aquí puedes agregar lógica para validar el usuario, los dispositivos, etc.

        LoanRequest newLoanRequest = new LoanRequest();
        newLoanRequest.setUser(loanRequestData.getUser());
        newLoanRequest.setDevices(loanRequestData.getDevices());
        newLoanRequest.setStartDate(loanRequestData.getStartDate());
        newLoanRequest.setEndDate(loanRequestData.getEndDate());
        newLoanRequest.setStatus(loanRequestData.getStatus());
        newLoanRequest.setQuantity(loanRequestData.getQuantity());

        loanRequestRepository.save(newLoanRequest);

        return ResponseEntity.ok(new MessageResponse("Loan request created successfully!"));
    }
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")  // Asegúrate de que solo los roles autorizados puedan confirmar los préstamos
    @PostMapping("/confirm")
    public ResponseEntity<?> loanConfirmation(@Valid @RequestBody LoanConfirmation loanConfirmationData) {
        // Verifica si la solicitud de préstamo existe
        LoanRequest loanRequest = loanRequestRepository.findById(loanConfirmationData.getLoanRequest().getId())
                .orElseThrow(() -> new RuntimeException("Error: Loan Request not found."));

        // Crea una nueva confirmación de préstamo
        LoanConfirmation newLoanConfirmation = new LoanConfirmation();
        newLoanConfirmation.setLoanRequest(loanRequest);
        newLoanConfirmation.setConfirmed(loanConfirmationData.getConfirmed());

        loanConfirmationRepository.save(newLoanConfirmation);

        return ResponseEntity.ok(new MessageResponse("Loan confirmation processed successfully!"));
    }
}