package com.megatera.makaogift.utils;

import com.auth0.jwt.exceptions.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

  static final String SECRET = "SECRET";

  JwtUtil jwtUtil;

  @BeforeEach
  void setUp() {
    jwtUtil = new JwtUtil(SECRET);
  }

  @Test
  void encodeAndDecode() {
    String userId = "makaoKim";
    String token = jwtUtil.encode(userId);

    assertThat(token).contains(".");

    String foundId = jwtUtil.decode(token);

    assertThat(foundId).isEqualTo(userId);
  }

  @Test
  void decodeError() {
    assertThrows(JWTDecodeException.class, () -> {
      jwtUtil.decode("xxx");
    });
  }
}
