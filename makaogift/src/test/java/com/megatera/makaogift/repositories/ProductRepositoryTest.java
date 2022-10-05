package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {
  @Autowired
  private ProductRepository productRepository;

  @Test
  void creation() {
    Product product = new Product(1L,"cup-maker", "mug",1000L);

    productRepository.save(product);

  }
}
