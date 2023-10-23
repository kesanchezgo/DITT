package com.bezkoder.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "laboratory_devices")
public class LaboratoryDevice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @Enumerated(EnumType.STRING)
  @NotNull
  private EDevice type;

  @NotBlank
  private String description;

  @NotNull
  private Integer quantity;

  // Otros campos y relaciones aquí

  public LaboratoryDevice() {
  }

  public LaboratoryDevice(String name, EDevice type, String description, Integer quantity) {
    this.name = name;
    this.type = type;
    this.description = description;
    this.quantity = quantity;
  }

  // Getters and setters

  // Relación con las imágenes del dispositivo
  @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<DeviceImage> images = new ArrayList<>();

  public void addImage(DeviceImage image) {
    images.add(image);
    image.setDevice(this);
  }

  public void removeImage(DeviceImage image) {
    images.remove(image);
    image.setDevice(null);
  }
}
