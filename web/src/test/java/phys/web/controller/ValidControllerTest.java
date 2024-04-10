package phys.web.controller;


import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import phys.web.common.normal.util.JacksonUtil;


@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
class ValidControllerTest {

  @Autowired
  private ValidController validController;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void whenUserControllerInjected_thenNotNull() {
    assertThat(validController).isNotNull();
  }

  @Test
  public void whenGetRequestToUsers_thenCorrectResponse() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders
                .post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JacksonUtil.toJson(new HashMap<>()))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
    MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
    String user = """
        {"name": "bob"}
        """;
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
  }

  @Test
  public void whenPostRequestToUsersAndInValidUser_thenCorrectReponse() throws Exception {
    String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .content(user)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void addUser() {

  }
}