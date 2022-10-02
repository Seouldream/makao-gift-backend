package com.megatera.makaogift.controllers;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void user() throws Exception {
    given(userService.detail("makaoKim")).willReturn(User.fake("makaoKim"));

    mockMvc.perform(MockMvcRequestBuilders.get("/users/me"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("\"userId\":\"makaoKim\"")
        ));
  }

  @Test
  void userNotFound() throws Exception {
    given(userService.detail("makaoKim"))
        .willThrow(new UserNotFound("makaoKim"));

    mockMvc.perform(MockMvcRequestBuilders.get("/users/me"))
        .andExpect(status().isBadRequest());
  }
}
