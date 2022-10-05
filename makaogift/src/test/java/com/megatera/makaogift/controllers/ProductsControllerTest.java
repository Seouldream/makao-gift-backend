package com.megatera.makaogift.controllers;

import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
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
    given(productService.list(1)).willReturn(
        List.of(new Product(1L,"cup-maker","mug",1000L))
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/products"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("mug")
        ));
  }
}
