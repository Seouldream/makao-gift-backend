package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("orders")
public class OrdersController {

  private final OrderService orderService;
  private final PlaceOrderService placeOrderService;

  public OrdersController(OrderService orderService, PlaceOrderService placeOrderService) {
    this.orderService = orderService;
    this.placeOrderService = placeOrderService;
  }

  @GetMapping
  public OrdersDto list(
      //@RequestAttribute("userId") String userId,
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {
    String userId = "makaoKim";
    List<OrderDto> orderDtos =
        orderService.list(userId, page)
            .stream()
            .map(order -> order.toDto())
            .collect(Collectors.toList());
    return new OrdersDto(orderDtos);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ChangedAmountDto placeAnOrder(
      //@RequestAttribute("userId") String userId,
      @Validated @RequestBody RequestedOrderDto requestedOrderDto
  ) {
    String userId = "makaoKim";
    Long amount =
        placeOrderService.placeAnOrder(
        userId,
        requestedOrderDto.getRecipient(),
        requestedOrderDto.getAddress(),
        requestedOrderDto.getMessage(),
        requestedOrderDto.getProductId(),
        requestedOrderDto.getQuantity(),
        requestedOrderDto.getAmount()
        );

    return new ChangedAmountDto(amount);
  }
}
