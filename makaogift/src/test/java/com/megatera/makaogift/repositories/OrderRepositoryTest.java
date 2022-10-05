package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.models.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderRepositoryTest {
  @Autowired
  private OrderRepository orderRepository;

  @Test
  void creation() {
    Order order = new Order(
        "makaoKim",
        2L,
        2000L,
        "makaoLee",
        "LA",
        "Do Better!",
        "cup-maker",
        "mug");

    orderRepository.save(order);

  }
}
