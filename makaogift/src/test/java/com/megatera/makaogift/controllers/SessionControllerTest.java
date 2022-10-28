package com.megatera.makaogift.controllers;

import com.megatera.makaogift.exceptions.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SessionController.class)
class SessionControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private LoginService loginService;

  @BeforeEach
  void setUp() {
    User user = new User(1L, "makaoKim", "makaoKim");

    given(loginService.login("makaoKim","makaoKim92!"))
        .willReturn(user);

    given(loginService.login("makaoKim","xxxx"))
        .willThrow(new LoginFailed());
  }

  @Test
  void loginSuccess() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"makaoKim\"," +
                "\"password\":\"makaoKim92!\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("\"amount\":")
        ));
  }

  @Test
  void loginFailed() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/session")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"userId\":\"makaoKim\"," +
                "\"password\":\"xxxx\"" +
                "}"))
        .andExpect(status().isBadRequest());
  }
}
