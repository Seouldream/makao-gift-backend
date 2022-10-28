package com.megatera.makaogift.controllers;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductsController.class)
@ActiveProfiles("test")
class ProductsControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Test
  void products() throws Exception {
    Product product = new Product(1L,"cup-maker","mug",1000L,"별내용없음",
        "https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/165120334937886080.jpg?w=2560&h=1536&c=c&webp=1");

    List<Product> products = List.of(product);

    given(productService.list(1)).willReturn(
        new PageImpl<>(products)
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/products"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("mug")
        ));
  }
}
