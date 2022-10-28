package com.megatera.makaogift.interceptors;

import com.auth0.jwt.exceptions.*;
import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.utils.*;
import org.springframework.web.servlet.*;

import javax.servlet.http.*;

public class AuthenticationInterceptor implements HandlerInterceptor {
  private final JwtUtil jwtUtil;

  public AuthenticationInterceptor(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {

    String authorization = request.getHeader(("Authorization"));

    if(authorization == null || !authorization.startsWith("Bearer ")) {
      //TODO 에러 처리 필요
      System.out.println("authorization: " + authorization);
      return true;
    }

    String accessToken = authorization.substring("Bearer ".length());

    try {
      String userId = jwtUtil.decode(accessToken);

      request.setAttribute("userId",userId);

      return true;
    } catch (JWTCreationException exception) {
      throw new AuthenticationError();
    }
  }
}
