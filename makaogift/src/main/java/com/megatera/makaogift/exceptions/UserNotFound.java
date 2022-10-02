package com.megatera.makaogift.exceptions;

public class UserNotFound extends RuntimeException {
  public UserNotFound(String userId) {
    super("User not found ( user ID: " + userId + ")");
  }
}
