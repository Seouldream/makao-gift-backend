package com.megatera.makaogift.models;

import com.megatera.makaogift.dtos.*;
import org.hibernate.annotations.*;
import org.springframework.security.crypto.password.*;

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

  private String encodedPassword;

  public User() {
  }

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public User(Long id, String userId, String name) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.amount = 50_000L;
  }

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
    this.amount = 50_000L;
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

  public String getPassword() {
    return encodedPassword;
  }

  public UserDto toDto() {
    return new UserDto(userId, name, amount);
  }

  public static User fake(String userId) {
    return new User(1L, userId, "makaoKim");
  }

  public void pay(Long amount) {
    this.amount -= amount;
  }

  public boolean authenticate(String password,PasswordEncoder passwordEncoder) {
    return passwordEncoder.matches(password, encodedPassword);
  }

  public void changePassword(String password, PasswordEncoder passwordEncoder) {
    encodedPassword = passwordEncoder.encode(password);
  }

  public UserCreatedDto toCreatedDto() {
    return new UserCreatedDto(id,userId,name);
  }
}
