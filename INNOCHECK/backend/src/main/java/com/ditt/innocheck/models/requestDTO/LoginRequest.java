package com.ditt.innocheck.models.requestDTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String dni;
    private String password;
}
