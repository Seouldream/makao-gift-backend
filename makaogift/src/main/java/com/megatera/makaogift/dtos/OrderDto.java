package com.megatera.makaogift.dtos;

import java.time.*;

public class OrderDto {
  private Long id;
  private Long quantity;
  private Long amount;
  private String recipient;
  private String message;
  private String brand;
  private String productName;
  private String url;
  private String registrationDate;


  public OrderDto() {
  }

  public OrderDto(Long id,
                  Long quantity,
                  Long amount,
                  String recipient,
                  String message,
                  String brand,
                  String productName,
                  String url,
                  String registrationDate) {
    this.id = id;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
    this.url = url;
    this.registrationDate = registrationDate;

  }


  public Long getId() {
    return id;
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

  public String getMessage() {
    return message;
  }

  public String getBrand() {
    return brand;
  }

  public String getProductName() {
    return productName;
  }

  public String getUrl() {
    return url;
  }

  public String getRegistrationDate() {
    return registrationDate;
  }
}
