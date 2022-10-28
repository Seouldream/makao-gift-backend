package com.megatera.makaogift.services;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceTest {
  private UserRepository userRepository;
  private UserService userService;
  private PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    passwordEncoder = new Argon2PasswordEncoder();
    userService = new UserService(userRepository, passwordEncoder);
  }

  @Test
  void user() {

    given(userRepository.findByUserId(any()))
        .willReturn(Optional.of(User.fake("makaoKim")));

    User user = userService.detail("makaoKim");

    verify(userRepository).findByUserId("makaoKim");

    assertThat(user.getUserId()).isEqualTo("makaoKim");
  }

  @Test
  void create() {

    UserRegistrationDto userRegistrationDto = new UserRegistrationDto(
        "makaoLee","makaoLee","makaoLee92!","makaoLee92!");

    User user = userService.create(userRegistrationDto);

    assertThat(user).isNotNull();

    verify(userRepository).save(user);
  }
}
