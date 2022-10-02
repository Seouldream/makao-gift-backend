package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("me")
  public UserDto user() {
    User user = userService.detail("makaoKim");
    return user.toDto();
  }

  @ExceptionHandler(UserNotFound.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String userNotFound() {
    return "User not found!";
  }
}
