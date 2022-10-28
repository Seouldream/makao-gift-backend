package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
public class ProductsController {
  private ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("products")
  @ResponseStatus(HttpStatus.OK)
  public ProductsDto list(
      @RequestParam(required = false, defaultValue = "1") Integer page
  ) {
    List<ProductDto> productDtos =
        productService.list(page)
            .stream()
            .map(product -> product.toDto())
            .collect(Collectors.toList());

    int pageNumber = productService.pages();

    return new ProductsDto(productDtos, pageNumber);
  }
}
