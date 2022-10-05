package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  void creation() {
    User user = new User("makaoKim", "makaoKim",50000L);

    userRepository.save(user);

  }
}
