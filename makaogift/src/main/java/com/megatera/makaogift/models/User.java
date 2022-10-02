package com.megatera.makaogift.models;

import com.megatera.makaogift.dtos.*;

import javax.persistence.*;

@Entity
public class User {
  @Id
  @GeneratedValue
  private Long id;

  private String userId;

  private String name;

  private Long amount;

//  public User() {
//  }

  public User(Long id, String userId, String name, Long amount) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.amount = amount;
  }

//  public Long getId() {
//    return id;
//  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public Long getAmount() {
    return amount;
  }

  public UserDto toDto() {
    return new UserDto(userId, name, amount);
  }

  public static User fake(String userId) {
    return new User(1L,userId,"makaoKim",50_000L);
  }
}
