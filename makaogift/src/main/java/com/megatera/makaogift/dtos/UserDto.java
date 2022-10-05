package com.megatera.makaogift.dtos;

public class UserDto {
  private Long id;
  private String userId;
  private String name;
  private Long amount;

  public UserDto() {
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public Long getAmount() {
    return amount;
  }

  public UserDto(String userId, String name, Long amount) {
    this.userId = userId;
    this.name = name;
    this.amount = amount;
  }
}
