package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByUserId(String userId, Pageable pageable);
}
