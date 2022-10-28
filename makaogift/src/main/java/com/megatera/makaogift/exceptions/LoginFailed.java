package com.megatera.makaogift.exceptions;

public class LoginFailed extends RuntimeException {
  public LoginFailed() {
    super("Login Failed");
  }
}
