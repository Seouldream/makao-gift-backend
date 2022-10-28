package com.megatera.makaogift.dtos;

import com.megatera.makaogift.groups.*;

import javax.validation.constraints.*;
import java.util.*;

public class UserRegistrationDto {
  @NotBlank(
      groups = NotBlankGroup.class,
      message = "이름을 입력해주세요"
  )
  @Pattern(
      groups = PatternMatchGroup.class,
      regexp = "^[가-힣]{3,7}$",
      message = "이름을 다시 확인해주세요"
  )
  private String name;

  @NotBlank(
      groups = NotBlankGroup.class,
      message = "아이디를 입력해주세요"
  )
  @Pattern(
      groups = PatternMatchGroup.class,
      regexp = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{4,16}$",
      message = "아이디를 다시 확인해주세요")
  private String userId;

  @NotBlank(
      groups = NotBlankGroup.class,
      message = "비밀번호를 입력해주세요")
  @Pattern(
      groups = PatternMatchGroup.class,
      regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d(?=.*@$!%*#?&)]{8,}$",
      message = "비밀번호를 다시 확인해주세요")
  private String password;

  @NotBlank(
      groups = NotBlankGroup.class,
  message = "확인 비밀번호를 입력해주세요")
  private String confirmPassword;

  public UserRegistrationDto(String name, String userId, String password, String confirmPassword) {
    this.name=name;
    this.userId=userId;
    this.password=password;
    this.confirmPassword=password;
  }

  public String getName() {
    return name;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  @Override
  public boolean equals(Object other) {
    UserRegistrationDto otherUserRegistrationDto = (UserRegistrationDto) other;
    return
    Objects.equals(this.name, ((UserRegistrationDto) other).name) &&
    Objects.equals(this.userId, ((UserRegistrationDto) other).userId) &&
    Objects.equals(this.password, ((UserRegistrationDto) other).password) &&
    Objects.equals(this.confirmPassword, ((UserRegistrationDto) other).confirmPassword);
  }
}
