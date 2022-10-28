package com.megatera.makaogift.exceptions;

public class ExistentUserId extends RuntimeException {
  public ExistentUserId() {
    super("이미 존재하는 아이디입니다.");
  }
}
