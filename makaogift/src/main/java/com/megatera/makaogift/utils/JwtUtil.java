package com.megatera.makaogift.utils;

import com.auth0.jwt.*;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.*;

public class JwtUtil {
  private Algorithm algorithm;

  public JwtUtil(String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  public String encode(String userId) {
    String token = JWT.create()
        .withClaim("userId",userId)
        .sign(algorithm);
    return token;
  }

  public String decode(String token) {
    JWTVerifier verifier = JWT.require(algorithm).build();
    DecodedJWT verify = verifier.verify(token);
    String value = verify.getClaim("userId").asString();

    return value;
  }
}
