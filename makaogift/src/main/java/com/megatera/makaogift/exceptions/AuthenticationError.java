package com.megatera.makaogift.exceptions;

public class AuthenticationError extends RuntimeException {
  public AuthenticationError() {
    super("인가 에러");
  }
}
