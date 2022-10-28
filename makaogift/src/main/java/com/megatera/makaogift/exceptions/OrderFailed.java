package com.megatera.makaogift.exceptions;

public class OrderFailed extends RuntimeException {
  public OrderFailed() {
    super("잔액이 부족합니다.");
  }
}
