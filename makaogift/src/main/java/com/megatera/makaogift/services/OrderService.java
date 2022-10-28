package com.megatera.makaogift.services;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
@Transactional
public class OrderService {
  private OrderRepository orderRepository;
  private ProductRepository productRepository;
  private UserRepository userRepository;
  private Pageable pageable;

  public OrderService(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
    this.userRepository = userRepository;
  }

  public Page<Order> list(String userId, int page) {
    Sort sort = Sort.by("createdAt").descending();
     pageable = PageRequest.of(page - 1, 8, sort);
    return orderRepository.findByUserId(userId,pageable);
  }

  public Long placeAnOrder(
      String userId,
      String recipient,
      String address,
      String message,
      Long productId,
      Long quantity,
      Long amount) {

    if(recipient == null || address == null || quantity == null || amount == null ) {
      throw new TransactionNotFound();
    }

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ProductNotFound(productId));

    Order order = new Order(userId,quantity,amount,recipient,address,message, product.getBrand(), product.getName(),product.getUrl());

    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UserNotFound(userId));

    if(amount > user.getAmount()) {
    throw new OrderFailed();
    }

    user.pay(amount);

    orderRepository.save(order);

    return user.getAmount();
  }

  public int pages(String userId) {
    return orderRepository.findByUserId(userId, pageable).getTotalPages();
  }
}
