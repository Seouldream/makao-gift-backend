package com.megatera.makaogift.dtos;

import java.util.*;

public class ProductsDto {
  private List<ProductDto> products;

  public ProductsDto(List<ProductDto> products) {
    this.products = products;
  }

  public ProductsDto() {
  }

  public List<ProductDto> getProducts() {
    return products;
  }
}
