package com.megatera.makaogift.controllers;

import com.megatera.makaogift.dtos.*;
import com.megatera.makaogift.models.*;
import com.megatera.makaogift.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.security.crypto.password.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @SpyBean
  private PasswordEncoder passwordEncoder;

  private User user;

  @BeforeEach
  void setUp() {
    user = new User(1L, "makaoKim", "makaoKim");

    given(userService.create( new UserRegistrationDto("makaoKim",
        "makaoKim",
        "makaoKim92!",
        "makaoKim92!")
    ))
        .willReturn(user);
  }

  @Test
  void register() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.post("/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{" +
                "\"name\":\"makaoKim\"," +
                "\"userId\":\"makaoKim\"," +
                "\"password\":\"makaoKim92!\"," +
                "\"confirmPassword\":\"makaoKim92!\"" +
                "}"))
        .andExpect(status().isCreated())
        .andExpect(content().string(
            containsString("\"name\":\"makaoKim\"")
        ));
  }
}
