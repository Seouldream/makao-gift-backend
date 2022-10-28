package com.megatera.makaogift.models;

import org.junit.jupiter.api.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  private PasswordEncoder passwordEncoder;
  @Test
  void authenticate() {
    passwordEncoder = new Argon2PasswordEncoder();

    User user = new User("makaoKim","makaoKim");

    user.changePassword("makaoKim92!",passwordEncoder);

    assertThat(user.authenticate("makaoKim92!",passwordEncoder)).isTrue();

    assertThat(user.authenticate("xxx",passwordEncoder)).isFalse();
  }
}
