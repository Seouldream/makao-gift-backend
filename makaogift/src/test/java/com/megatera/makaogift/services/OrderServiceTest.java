package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.models.Order;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OrderServiceTest {
  private OrderRepository orderRepository;
  private OrderService orderService;

  @BeforeEach
  void setUp() {
    orderRepository = mock(OrderRepository.class);
    orderService = new OrderService(orderRepository);
  }
  @Test
  void list() {
    User user = new User(1L,"makaoKim","makaoKim",50_000L);

    Order order = mock(Order.class);

    given(orderRepository.findByUserId(eq(user.getUserId()),any()))
        .willReturn(List.of(order));

    List<Order> orders = orderService.list(user.getUserId(),1);

    assertThat(orders).hasSize(1);
  }
}
