package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.models.Order;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceTest {
  private OrderRepository orderRepository;
  private OrderService orderService;
  private ProductRepository productRepository;
  private UserRepository userRepository;



  @BeforeEach
  void setUp() {
    orderRepository = mock(OrderRepository.class);
    productRepository = mock(ProductRepository.class);
    userRepository = mock(UserRepository.class);
    orderService = new OrderService(orderRepository, productRepository, userRepository);

  }

  @Test
  void list() {
    User user = new User(1L, "makaoKim", "makaoKim");

    List<Order> orders = new ArrayList<>();

    Order order = new Order();

    orders.add(order);

    int page = 1;

    Pageable pageable = PageRequest.of(page - 1, 8);

    Page<Order> inu =  new PageImpl<>(orders, pageable,8);
    given(orderRepository.findByUserId(eq(user.getUserId()), any()))
        .willReturn(inu);

    assertThat(orderService.list(user.getUserId(), 1)).isEqualTo(inu);

    assertThat(orders).hasSize(1);
  }

  @Test
  void placeAnOrder() {
    User user = new User(1L, "makaoKim", "makaoKim");

    Product product = new Product(1L, "cup-maker", "mug", 5_000L, "나띵",
        "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/165120334937886080.jpg?w=2560&h=1536&c=c&webp=1");


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

    orderService.placeAnOrder(user.getUserId(), recipient, address, message, productId, quantity, amount);

    assertThat(user.getAmount()).isEqualTo(40_000L);
    verify(orderRepository).save(any());
  }

  @Test
  void placeAnOrderWithLowAmount() {
    User user = new User(1L, "makaoKim", "makaoKim");

    Product product = new Product(1L, "cup-maker", "mug", 5_000L, "나띵",
        "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/165120334937886080.jpg?w=2560&h=1536&c=c&webp=1");


    String recipient = "makaoLee";
    String address = "LA";
    String message = "Do Better!";
    Long productId = 1L;
    Long quantity = 10L;
    Long amount = 100000L;


    given(productRepository.findById(any()))
        .willReturn(Optional.of(product));
    given(userRepository.findByUserId(user.getUserId()))
        .willReturn(Optional.of(user));

    assertThrows(OrderFailed.class,
        () -> orderService.placeAnOrder(user.getUserId(), recipient, address, message, productId, quantity, amount));

  }
}
