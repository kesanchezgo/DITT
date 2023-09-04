/* package com.ditt.innocheck.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ditt.innocheck.models.User;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private Long id;
    private String dni;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        return new UserPrincipal(
            user.getId(),
            user.getDni(),
            user.getPassword(),
            user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName())).collect(Collectors.toList())
            //,
            // Aquí debes proporcionar una colección de las autoridades (roles) del usuario
            // Puedes obtenerlas de la entidad User o cargarlas desde tu base de datos
            // Ejemplo: user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
    }

    @Override
    public String getUsername() {
        return dni;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
 */