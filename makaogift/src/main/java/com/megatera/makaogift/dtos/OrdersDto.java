package com.megatera.makaogift.dtos;

import java.util.*;

public class OrdersDto {
  private List<OrderDto> orders;

  public OrdersDto() {
  }

  public OrdersDto(List<OrderDto> orders) {
    this.orders = orders;
  }

  public List<OrderDto> getOrders() {
    return orders;
  }
}