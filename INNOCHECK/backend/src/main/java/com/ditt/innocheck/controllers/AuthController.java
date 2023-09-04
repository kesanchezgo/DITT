/* package com.ditt.innocheck.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import com.ditt.innocheck.errros.ErrorResponse;
import com.ditt.innocheck.models.User;
import com.ditt.innocheck.models.responseDTO.LoginResponse;
import com.ditt.innocheck.security.JwtUtil;
import com.ditt.innocheck.security.LoginRequest;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    private final AuthenticationManager authenticationManager;


    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequest loginReq)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getDni(), loginReq.getPassword()));
            String dni = authentication.getName();
            User user = new User();
            String token = jwtUtil.createToken(user);
            LoginResponse loginRes = new LoginResponse();
            loginRes.setDni(token);
            loginRes.setDni(dni);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
   
}
 */

 package com.ditt.innocheck.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import com.ditt.innocheck.security.JwtResponse;
import com.ditt.innocheck.security.LoginRequest;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getDni(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getDni());

        String jwt = generateJwtToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    private String generateJwtToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()), SignatureAlgorithm.HS512)
                .compact();
    }
}
