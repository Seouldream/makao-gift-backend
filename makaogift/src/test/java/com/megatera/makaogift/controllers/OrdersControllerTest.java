package com.megatera.makaogift.controllers;

import com.megatera.makaogift.models.Order;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrdersController.class)
class OrdersControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrderService orderService;

  @MockBean
  private ProductService productService;

  @MockBean
  private PlaceOrderService placeOrderService;

  @Test
  void list() throws Exception {
    User user = new User(1L,"makaoKim","makaoKim",50_000L);

    given(orderService.list(user.getUserId(),1)).willReturn(
        List.of(new Order(1L,
            "makaoKim",
            2L,
            2000L,
            "makaoLee",
            "LA",
            "Do Better!",
            "cup-maker",
            "mug"))
    );

    mockMvc.perform(MockMvcRequestBuilders.get("/orders")
            .requestAttr("userId","makaoKim"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("Do Better!")
        ));
  }

  @Test
  void placeAnOrder() throws Exception {
    User user = new User(1L, "makaoKim", "makaoKim", 50_000L);

    Product product = new Product(1L, "cup-maker", "mug", 5_000L);

    String recipient = "makaoLee";
    String address = "LA";
    String message = "Do Better!";
    Long productId = 1L;
    Long quantity = 2L;
    Long amount = 10000L;

    mockMvc.perform(MockMvcRequestBuilders.post("/orders")
            .requestAttr("userId","makaoKim")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"recipient\":\"makaoLee\"," +
                "\"address\":\"LA\"," +
                "\"message\":\"Do Better!\"," +
                "\"productId\":1," +
                "\"quantity\":2," +
                "\"amount\":10000" +
                "}"))
        .andExpect(status().isCreated());

    verify(placeOrderService).placeAnOrder(user.getUserId(), recipient, address, message, productId, quantity, amount);
  }
  //ToDO 예외 처리 테스트 코드와 코드 잡아줄 것
}
