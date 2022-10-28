package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.models.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
class OrderRepositoryTest {
  @Autowired
  private OrderRepository orderRepository;

  @Test
  void creation() {
//    orderRepository = mock(OrderRepository.class);

    Order order = new Order(
        "makaoKim",
        2L,
        2000L,
        "makaoLee",
        "LA",
        "Do Better!",
        "cup-maker",
        "mug",
        "url"
    );

    orderRepository.save(order);

  }
}
