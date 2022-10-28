package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import com.megatera.makaogift.utils.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("session")
public class SessionController {

  private LoginService loginService;
  private JwtUtil jwtUtil;

  public SessionController(LoginService loginService, JwtUtil jwtUtil) {
    this.loginService = loginService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoginResultDto login(
      @RequestBody LoginRequestDto loginRequestDto
  ) {

    User user = loginService.login(
        loginRequestDto.getUserId(), loginRequestDto.getPassword());

    String accessToken = jwtUtil.encode(user.getUserId());
    return new LoginResultDto(
        accessToken,
        user.getName(),
        user.getAmount()
    );
  }

  @ExceptionHandler(LoginFailed.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto loginFailed() {
    return new IncorrectUserErrorDto();
  }

  @ExceptionHandler(IdNotFound.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto idNotFound() {
    return new IncorrectIdErrorDto();
  }

  @ExceptionHandler(WrongPasswordError.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto wrongPassword() {
    return new IncorrectPasswordErrorDto();
  }
}
