package com.megatera.makaogift.models;

import com.megatera.makaogift.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;

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

  public Order() {
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;


  public Order(Long id, String userId, Long quantity, Long amount, String recipient, String address, String message, String brand, String productName) {
    this.id = id;
    this.userId = userId;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.address = address;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
  }

  public Order(String userId, Long quantity, Long amount, String recipient, String address, String message, String brand, String productName) {
    this.userId = userId;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.address = address;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
  }

  public Long getId() {
    return id;
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
    return new OrderDto(id, quantity, amount, recipient, message, brand, productName);
  }
}

