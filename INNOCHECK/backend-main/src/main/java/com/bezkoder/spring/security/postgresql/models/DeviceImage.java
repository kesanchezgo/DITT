package com.bezkoder.spring.security.postgresql.models;

import jakarta.persistence.*;

@Entity
@Table(name = "device_images")
public class DeviceImage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "device_id")
  private LaboratoryDevice device;

  private String imageUrl;

  public DeviceImage() {
  }

  public DeviceImage(LaboratoryDevice device, String imageUrl) {
    this.device = device;
    this.imageUrl = imageUrl;
  }

  // Getters and setters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LaboratoryDevice getDevice() {
        return this.device;
    }

    public void setDevice(LaboratoryDevice device) {
        this.device = device;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
