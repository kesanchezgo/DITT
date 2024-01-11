package com.bezkoder.spring.security.postgresql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "invitations")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private ParticipationGroup group;

    @Column(nullable = false, unique = true)
    private String token;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ParticipationGroup getGroup() {
        return group;
    }

    public String getToken() {
        return token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGroup(ParticipationGroup group) {
        this.group = group;
    }

    public void setToken(String token) {
        this.token = token;
    }
}