package com.megatera.makaogift.services;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@Transactional
public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> list(int page) {
    Sort sort = Sort.by("createdAt").descending();
    Pageable pageable = PageRequest.of(page - 1, 8, sort);
    return productRepository.findAll();
  }
}
