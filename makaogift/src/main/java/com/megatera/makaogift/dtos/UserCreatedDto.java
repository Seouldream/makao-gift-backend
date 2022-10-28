package com.megatera.makaogift.dtos;

public class UserCreatedDto {
  private Long id;
  private String userId;
  private String name;

  public Long getId() {
    return id;
  }

  public UserCreatedDto(Long id, String userId, String name) {
    this.id=id;
    this.userId=userId;
    this.name=name;
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public UserCreatedDto() {
  }
}
