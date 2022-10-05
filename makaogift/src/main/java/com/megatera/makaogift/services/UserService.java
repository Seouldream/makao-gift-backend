package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User detail(String userId) {
    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UserNotFound(userId));
    return user;
  }
}
