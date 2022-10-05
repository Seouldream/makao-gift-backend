package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PlaceOrderServiceTest {

  private ProductRepository productRepository;
  private OrderRepository orderRepository;
  private PlaceOrderService placeOrderService;
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    productRepository = mock(ProductRepository.class);
    orderRepository = mock(OrderRepository.class);

    placeOrderService = new PlaceOrderService(userRepository, productRepository, orderRepository);
  }

  @Test
  void placeAnOrder() {
    User user = new User(1L, "makaoKim", "makaoKim", 50_000L);

    Product product = new Product(1L, "cup-maker", "mug", 5_000L);


    String recipient = "makaoLee";
    String address = "LA";
    String message = "Do Better!";
    Long productId = 1L;
    Long quantity = 2L;
    Long amount = 10000L;


    given(productRepository.findById(any()))
        .willReturn(Optional.of(product));
    given(userRepository.findByUserId(user.getUserId()))
        .willReturn(Optional.of(user));

    placeOrderService.placeAnOrder(user.getUserId(), recipient, address, message, productId, quantity, amount);

    assertThat(user.getAmount()).isEqualTo(40_000L);
    verify(orderRepository).save(any());
  }
}
