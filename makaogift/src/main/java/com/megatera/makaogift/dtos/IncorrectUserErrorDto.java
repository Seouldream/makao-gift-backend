package com.megatera.makaogift.dtos;

public class IncorrectUserErrorDto extends ErrorDto {
  public IncorrectUserErrorDto() {
    super(1001, "아이디 혹은 비밀번호가 맞지 않습니다.");
  }
}
