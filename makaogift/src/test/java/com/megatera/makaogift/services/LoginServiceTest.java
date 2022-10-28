package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LoginServiceTest {
  private LoginService loginService;
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private User user;

  @BeforeEach
  void setUp() {
    passwordEncoder = new Argon2PasswordEncoder();

    userRepository = mock(UserRepository.class);

    loginService = new LoginService(userRepository,passwordEncoder);

    user = new User("makaoKim", "makaoKim");

    user.changePassword("makaoKim92!",passwordEncoder);
  }

  @Test
  void loginWithCorrectInfo() {

    given(userRepository.findByUserId(any()))
        .willReturn(Optional.of(user));

    assertThat(loginService.login("makaoKim","makaoKim92!")).isEqualTo(user);
  }

  @Test
  void loginWithWrongId() {
    assertThrows(LoginFailed.class, () -> {
      loginService.login("makaoLee","makaoKim92!");
    });

  }
}
