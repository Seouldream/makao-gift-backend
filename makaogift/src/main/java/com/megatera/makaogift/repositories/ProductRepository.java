package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;

import org.springframework.data.jpa.repository.*;


import java.awt.print.Pageable;
import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAll();

  Optional<Product> findById(Long productId);
}
