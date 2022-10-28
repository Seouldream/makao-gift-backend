package com.megatera.makaogift;

import com.megatera.makaogift.interceptors.*;
import com.megatera.makaogift.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.argon2.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class MakaogiftApplication {
  @Value("${jwt.secret}")
  private String jwtSecret;

  public static void main(String[] args) {
    SpringApplication.run(MakaogiftApplication.class, args);
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/**");
  }

  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
      }

      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor());
      }
    };
  }

  @Bean
  public AuthenticationInterceptor authenticationInterceptor() {
    return new AuthenticationInterceptor(jwtUtil());
  }

  @Bean
  public JwtUtil jwtUtil() {
    return new JwtUtil(jwtSecret);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new Argon2PasswordEncoder();
  }
}
