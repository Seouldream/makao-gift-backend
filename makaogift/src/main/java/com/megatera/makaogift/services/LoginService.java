package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

@Service
public class LoginService {

  private UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public LoginService(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User login(String userId, String password) {
    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new IdNotFound());

    if(!user.authenticate(password,passwordEncoder)) {
      throw new WrongPasswordError();
    }

    return user;
  }
}
