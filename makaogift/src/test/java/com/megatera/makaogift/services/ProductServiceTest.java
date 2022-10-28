package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
  private ProductService productService;
  private ProductRepository productRepository;

  @SpyBean
  private Pageable pageable;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    productService = new ProductService(productRepository);
  }
  @Test
  void list() {

    Product product = mock(Product.class);

    List<Product> products = new ArrayList<>();
    products.add(product);

    Page<Product> page = new PageImpl<>(products);

    given(productRepository.findAll(pageable)).willReturn(page);

    assertThat(products).hasSize(1);

    assertThat(product.getId()).isNotNull();

  }
}
