package com.megatera.makaogift.exceptions;

public class IdNotFound extends RuntimeException {
  public IdNotFound() {
    super("존재하지 않는 아이디입니다");
  }
}
