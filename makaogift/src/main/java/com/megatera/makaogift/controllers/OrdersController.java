package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
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

  public OrdersController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public OrdersDto list(
      @RequestAttribute("userId") String userId,
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {

    List<OrderDto> orderDtos =
        orderService.list(userId, page)
            .stream()
            .map(Order::toDto)
            .collect(Collectors.toList());

    int pageNumber = orderService.pages(userId);

    return new OrdersDto(orderDtos, pageNumber);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ChangedAmountDto placeAnOrder(
      @RequestAttribute("userId") String userId,
      @Validated @RequestBody RequestedOrderDto requestedOrderDto
  ) {

    Long amount =
        orderService.placeAnOrder(
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

  @ExceptionHandler(TransactionNotFound.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String transactionNotFound() {
    return "거래내역을 불러올 수 없습니다.";
  }
}
