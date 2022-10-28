package com.megatera.makaogift.exceptions;

public class ProductNotFound extends RuntimeException {
  public ProductNotFound(Long productId) {
    super("상품을 불러올 수 없습니다.");
  }
}
