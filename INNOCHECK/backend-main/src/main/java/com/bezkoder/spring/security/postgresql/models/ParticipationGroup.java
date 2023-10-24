package com.bezkoder.spring.security.postgresql.models;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;

@Entity
@Table(name = "participation_groups")
public class ParticipationGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @OneToOne
  private Project project;

  @OneToOne
  private User leader;

  @ManyToMany
  private Set<User> members = new HashSet<>();

  public ParticipationGroup() {
  }

  public ParticipationGroup(String name, Project project, User leader, Set<User> members) {
    this.name = name;
    this.project = project;
    this.leader = leader;
    this.members = members;
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public User getLeader() {
    return leader;
  }

  public void setLeader(User leader) {
    this.leader = leader;
  }

  public Set<User> getMembers() {
    return members;
  }

  public void setMembers(Set<User> members) {
    this.members = members;
  }
}
