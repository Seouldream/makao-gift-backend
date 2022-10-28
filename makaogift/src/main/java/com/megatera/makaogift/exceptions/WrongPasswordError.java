package com.megatera.makaogift.exceptions;

public class WrongPasswordError extends RuntimeException {
  public WrongPasswordError() {
    super("비밀번호가 일치하지 않습니다");
  }
}
