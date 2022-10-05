package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class PlaceOrderService {

  private ProductRepository productRepository;
  private OrderRepository orderRepository;
  private UserRepository userRepository;

  public PlaceOrderService( UserRepository userRepository,ProductRepository productRepository, OrderRepository orderRepository) {
    this.productRepository = productRepository;
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  public Long placeAnOrder(
      String userId,
      String recipient,
      String address,
      String message,
      Long productId,
      Long quantity,
      Long amount) {

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ProductNotFound(productId));

    Order order = new Order(userId,quantity,amount,recipient,address,message, product.getBrand(), product.getName());

    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UserNotFound(userId));

    user.pay(amount);

    orderRepository.save(order);

    return 22L;
  }
}
