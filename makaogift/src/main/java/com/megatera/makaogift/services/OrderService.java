package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class OrderService {
  private OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> list(String userId, int page) {
    Sort sort = Sort.by("createdAt").descending();
    Pageable pageable = PageRequest.of(page - 1, 8, sort);
    return orderRepository.findByUserId(userId,pageable);
  }
}
