package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceTest {
  private UserRepository userRepository;
  private UserService userService;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);

    userService = new UserService(userRepository);

    given(userRepository.findByUserId(any()))
        .willReturn(Optional.of(User.fake("makaoKim")));

  }

  @Test
  void user() {

    User user = userService.detail("makaoKim");

    verify(userRepository).findByUserId("makaoKim");

    assertThat(user.getUserId()).isEqualTo("makaoKim");
  }
}
