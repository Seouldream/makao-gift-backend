package com.megatera.makaogift.models;

import com.fasterxml.jackson.annotation.*;
import com.megatera.makaogift.dtos.*;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;
import java.time.format.*;

@Entity
@Table(name = "PURCHASE")
public class Order {
  @Id
  @GeneratedValue
  private Long id;
  private String userId;
  private Long quantity;
  private Long amount;
  private String recipient;
  private String address;
  private String message;
  private String brand;
  private String productName;
  private String url;

  public Order() {
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;


  public Order(Long id, String userId, Long quantity, Long amount, String recipient, String address, String message, String brand, String productName, String url) {
    this.id = id;
    this.userId = userId;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.address = address;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
    this.url = url;
  }

  public Order(String userId, Long quantity, Long amount, String recipient, String address, String message, String brand, String productName, String url) {
    this.userId = userId;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.address = address;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
    this.url = url;
  }

  public Long getId() {
    return id;
  }


  public String getUrl() {
    return url;
  }

  public String getUserId() {
    return userId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Long getAmount() {
    return amount;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getAddress() {
    return address;
  }

  public String getMessage() {
    return message;
  }

  public String getBrand() {
    return brand;
  }

  public String getProductName() {
    return productName;
  }


  public OrderDto toDto() {
    String registrationDate = createdAt == null ? "" : createdAt.toLocalDate().toString();

    return new OrderDto(id, quantity, amount, recipient, message, brand, productName, url, registrationDate);
  }
}

