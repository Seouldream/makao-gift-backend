package com.megatera.makaogift.dtos;

public class OrderDto {
  private Long id;
  private Long quantity;
  private Long amount;
  private String recipient;
  private String message;
  private String brand;
  private String productName;

  public OrderDto() {
  }

  public OrderDto(Long id, Long quantity, Long amount, String recipient, String message, String brand, String productName) {
    this.id = id;
    this.quantity = quantity;
    this.amount = amount;
    this.recipient = recipient;
    this.message = message;
    this.brand = brand;
    this.productName = productName;
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
}
