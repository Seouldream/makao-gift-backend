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
  private Pageable pageable;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Page<Product> list(int page) {
    Sort sort = Sort.by("createdAt").descending();
     pageable = PageRequest.of(page - 1, 8, sort);
    return productRepository.findAll(pageable);
  }

  public int pages() {
    return productRepository.findAll(pageable).getTotalPages();
  }
}
