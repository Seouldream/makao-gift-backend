package com.megatera.makaogift.repositories;

import com.megatera.makaogift.models.*;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;


import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findAll(Pageable pageable);

  Optional<Product> findById(Long productId);
}
