package com.megatera.makaogift.dtos;

import java.util.*;

public class OrdersDto {
  private List<OrderDto> orders;

  private int pageNumber;

  public OrdersDto() {
  }

  public OrdersDto(List<OrderDto> orders, int pageNumber) {
    this.orders = orders;
    this.pageNumber = pageNumber;
  }

  public List<OrderDto> getOrders() {
    return orders;
  }

  public int getPageNumber() {
    return pageNumber;
  }
}
