package com.megatera.makaogift.dtos;

public class LoginResultDto {
  private String accessToken;
  private String name;
  private Long amount;

  public LoginResultDto(String accessToken, String name, Long amount) {
    this.accessToken = accessToken;
    this.name = name;
    this.amount = amount;
  }

  public LoginResultDto() {
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getName() {
    return name;
  }

  public Long getAmount() {
    return amount;
  }
}