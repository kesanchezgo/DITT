package com.ditt.innocheck.security;

import lombok.Data;

@Data
public class LoginRequest {
    private String dni;
    private String password;
}
