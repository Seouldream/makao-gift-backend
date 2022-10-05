package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserId(String userId);

  User save(User user);
}
