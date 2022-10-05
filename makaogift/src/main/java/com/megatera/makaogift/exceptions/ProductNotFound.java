package com.megatera.makaogift.exceptions;

public class ProductNotFound extends RuntimeException {
  public ProductNotFound(Long productId) {
    super("Product Not Found: " + productId + ")");
  }
}
