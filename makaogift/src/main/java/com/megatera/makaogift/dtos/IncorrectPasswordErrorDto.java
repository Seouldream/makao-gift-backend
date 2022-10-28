package com.megatera.makaogift.dtos;

public class IncorrectPasswordErrorDto extends ErrorDto {
  public IncorrectPasswordErrorDto() {
    super(1002, "잘못된 비밀번호입니다.");
  }
}
