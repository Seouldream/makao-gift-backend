package com.megatera.makaogift.models;

import com.megatera.makaogift.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.*;

@Entity
public class Product {
  @Id
  @GeneratedValue
  private Long id;
  private String brand;
  private String name;
  private Long price;
  private String description;
  private String url;

  public Product() {
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Product(Long id, String brand, String name, Long price,String description, String url) {
    this.id = id;
    this.brand = brand;
    this.name = name;
    this.price = price;
    this.description = description;
    this.url= url;
  }

  public Long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public ProductDto toDto() {
    return new ProductDto(id, brand, name, price,description,url);
  }
}
