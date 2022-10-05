package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductServiceTest {
  private ProductService productService;
  private ProductRepository productRepository;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    productService = new ProductService(productRepository);
  }
  @Test
  void list() {

    Product product = mock(Product.class);

    given(productRepository.findAll())
        .willReturn(List.of(product));

    List<Product> products = productService.list(1);

    assertThat(products).hasSize(1);

    assertThat(product.getId()).isNotNull();
  }
}
