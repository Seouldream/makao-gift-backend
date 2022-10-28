package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public UserCreatedDto register(
      @RequestBody UserRegistrationDto userRegistrationDto
  ) {
    User user = userService.create(userRegistrationDto);

    return user.toCreatedDto();
  }
}
