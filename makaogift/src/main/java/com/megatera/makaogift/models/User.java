package com.megatera.makaogift.models;

import com.megatera.makaogift.dtos.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;


@Entity
@Table(name = "PERSON")
public class User {
  @Id
  @GeneratedValue
  private Long id;

  private String userId;

  private String name;

  private Long amount;

  public User() {
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public User(Long id, String userId, String name, Long amount) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.amount = amount;
  }

  public User(String userId, String name,Long amount) {
    this.userId = userId;
    this.name = name;
    this.amount = amount;
  }

  public Long getId() {
    return id;
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

  public UserDto toDto() {
    return new UserDto(userId, name, amount);
  }

  public static User fake(String userId) {
    return new User(1L, userId, "makaoKim", 50_000L);
  }

  public void pay(Long amount) {
    this.amount -= amount;
  }
}
