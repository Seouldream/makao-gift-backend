package com.megatera.makaogift.services;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User detail(String userId) {
    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UserNotFound(userId));
    return user;
  }

  public User create(UserRegistrationDto userRegistrationDto) {
    if(userRepository.findByUserId(userRegistrationDto.getUserId()).isPresent()) {
      throw new ExistentUserId();
    }

    User user = new User(null,userRegistrationDto.getUserId(), userRegistrationDto.getName());

    user.changePassword(userRegistrationDto.getPassword(),passwordEncoder);

    userRepository.save(user);

    return user;
  }
}
