package com.megatera.makaogift.dtos;

public class RequestedOrderDto {
  private String recipient;
  private String address;
  private String message;
  private Long productId;
  private Long quantity;
  private Long amount;

  public RequestedOrderDto(String recipient, String address, String message, Long productId, Long quantity, Long amount) {
    this.recipient = recipient;
    this.address = address;
    this.message = message;
    this.productId = productId;
    this.quantity = quantity;
    this.amount = amount;
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

  public Long getProductId() {
    return productId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Long getAmount() {
    return amount;
  }
}
